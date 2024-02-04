package com.pactera.dataserver.core.sbcf.configuration;

public enum DataClass {
    /**
     * GUNMA_DEV_ACCOUNT_DATA
     */
    GUNMA_DEV_ACCOUNT_DATA("GUNMA_DEV_ACCOUNT_DATA", "群馬銀行開発用口座データクラス"),
    /**
     * GUNMA_DEV_ACOM_DATA
     */
    GUNMA_DEV_ACOM_DATA("GUNMA_DEV_ACOM_DATA", "群馬銀行開発用アコムデータクラス"),
    /**
     * GUNMA_DEV_IMAGE_DATA
     */
    GUNMA_DEV_IMAGE_DATA("GUNMA_DEV_IMAGE_DATA", "群馬銀行開発用画像データクラス"),
    /**
     * GUNMABANK_ACCOUNT_APPLICATION
     */
    GUNMABANK_ACCOUNT_APPLICATION("GUNMABANK_ACCOUNT_APPLICATION", "群馬銀行口座開設申込情報");

    private String dataClass;
    private String adminName;

    DataClass(String dataClass, String adminName) {
        this.dataClass = dataClass;
        this.adminName = adminName;
    }

    public String getAdminName() {
        return this.adminName;
    }

    public String getDataClass() {
        return dataClass;
    }
}
