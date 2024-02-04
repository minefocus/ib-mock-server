package com.pactera.dataserver.core.sbcf;

public enum SbcfErrorCode {
    /**
     *
     */
    EC_PROVF_0034("EC-PROVF.0034"),
    /**
     *
     */
    EC_PROVF_0035("EC-PROVF.0035"),
    /**
     *
     */
    ECONCIER_0131("ECONCIER.0131"),
    /**
     *
     */
    ECONCIER_0132("ECONCIER.0132");

    private final String code;

    SbcfErrorCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
