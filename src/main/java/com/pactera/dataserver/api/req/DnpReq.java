package com.pactera.dataserver.api.req;

import com.pactera.dataserver.core.sbcf.UtilDoc;
import lombok.Data;

/**
 * @author Pactera WangShuai
 * @date 2019/12/24 11:05
 */
@Data
public class DnpReq extends UtilDoc {
    private String ak;
    private String device_name;
    private String device_os_version;
    private String health_image1;
    private String health_image2;
    private String image_1;
    private String image_2;
    private String image_flg;
    private String name;
    private String original_image;
    private String receipt_image1;
    private String reg_date;
    private String tokendate;
    private String tokenkey;
    private String type;
    private String uk;
    private String resident_image1;
    private String resident_image2;
    private String parent_resident_image1;
    private String parent_resident_image2;

}
