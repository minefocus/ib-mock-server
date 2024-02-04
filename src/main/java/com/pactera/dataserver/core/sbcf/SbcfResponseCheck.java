package com.pactera.dataserver.core.sbcf;

import com.pactera.dataserver.core.sbcf.res.SbcfData;
import com.pactera.dataserver.core.sbcf.res.SbcfError;
import com.pactera.dataserver.core.sbcf.res.SbcfResponse;
import org.springframework.util.Assert;

import java.util.List;

public class SbcfResponseCheck {

    /**
     * エラーチェック
     *
     * @param response レスポンスオブジェクト
     * @return エラーがある場合はtrueを返します。
     */
    public static boolean errorCheck(SbcfResponse response) {
        Assert.notNull(response, "");
        List<SbcfError> errorList = response.getResponseHeader().getErrorList();
        return errorList != null && errorList.size() > 0;
    }

    public static Exception throwException(SbcfResponse response) {
        SbcfError error = response.getResponseHeader().getErrorList().get(0);
        if (SbcfErrorCode.EC_PROVF_0034.getCode().equals(error.getErrorCd())
                || SbcfErrorCode.EC_PROVF_0035.getCode().equals(error.getErrorCd())
                || SbcfErrorCode.ECONCIER_0131.getCode().equals(error.getErrorCd())
                || SbcfErrorCode.ECONCIER_0132.getCode().equals(error.getErrorCd())) {
            return new Exception(error.getErrorCd() + " : " + error.getErrorMessage());
        } else {
            return new Exception("sbcf.system.error");
        }
    }

    /**
     * データリストチェック
     *
     * @param response レスポンスオブジェクト
     * @return データリストがある場合はtrueを返します。
     */
    public static <D extends UtilDoc> boolean dataListCheck(SbcfResponse<D> response) {
        Assert.notNull(response, "");
        List<SbcfData<D>> dataList = response.getDataList();
        return dataList != null && dataList.size() > 0;
    }

    /**
     * データチェック
     *
     * @param response レスポンスオブジェクト
     * @return データがある場合はtrueを返します。
     */
    public static boolean dataCheck(SbcfResponse response) {
        Assert.notNull(response, "");
        SbcfData data = response.getData();
        return data != null;
    }
}
