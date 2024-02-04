package com.pactera.dataserver;

/**
 * CommonMassage
 *
 * @author Pactera chaiyong
 * @date 2019/10/15 16:14
 */
public class CommonMessage {

    /**
     * table attribute
     */
    public static final String SCHEMA = "minefocus";

    /**
     * sequence name
     */
    public static final String GUNMA_DEV_ACCOUNT_DATA_SEQ = "gunma_dev_account_data_id_seq";

    /**
     * sequence sql
     */
    public static final String FIND_GUNMA_DEV_ACCOUNT_DATA_SEQ = "SELECT nextval('" + SCHEMA + "." + GUNMA_DEV_ACCOUNT_DATA_SEQ + "')";


}
