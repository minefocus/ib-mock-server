package com.pactera.dataserver.core.sbcf;

import lombok.Data;

/**
 * Database DOC
 */
@Data
public class UtilDoc {
    // id
    private String _oid;
    // rev
    private String _rev;
    // 作成者
    private String created_id = "";
    // 作成日時
    private long created_at = 0L;
    // 更新者
    private String updated_id = "";
    // 更新日時
    private long updated_at = 0L;
    // 削除フラグ
    private boolean is_del = false;

}
