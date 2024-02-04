package com.pactera.dataserver.api.req;

import com.pactera.dataserver.core.sbcf.UtilDoc;
import lombok.Data;

@Data
public class OidReq extends UtilDoc {
     String appVer;
    // 端末識別情報
     String deviceIdentification;
    // 申込み日時
     String applicationDate;
    // 申込み区分
     String applicationType;
    // 訂正対象のOID
     String revisionOid;
    // 銀行システム送信結果（口座）
     String bankAccountSendStatus;
    // 銀行システム送信時間（口座）
     String bankAccountSendDate;
    // 銀行システム送信結果（住所）
     String bankAddressSendStatus;
    // 銀行システム送信時間（住所）
     String bankAddressSendDate;
    // DNPシステム送信結
     String dnpSendStatus;
    // DNPシステム送信時
     String dnpSendDate;
    // アコムシステム送信結果
     String acomSendStatus;
    // アコムシステム送信時
     String acomSendDate;
    // 送信status
     String sendStatus;
    // 送信エラー内容
     String errorMsg;
    // 完了日時
     String compDate;
}
