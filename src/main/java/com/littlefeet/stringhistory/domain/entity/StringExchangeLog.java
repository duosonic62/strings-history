    package com.littlefeet.stringhistory.domain.entity;

    import java.time.LocalDateTime;
    import org.seasar.doma.Column;
    import org.seasar.doma.Entity;
    import org.seasar.doma.Id;
    import org.seasar.doma.Table;
    import org.seasar.doma.Version;

/**
    * 
*/
@Entity
    @Table(name = "string_exchange_log")
public class StringExchangeLog {

        /** 弦交換id */
        @Id
        @Column(name = "id")
    public String id;

        /** 弦id */
        @Column(name = "string_id")
    public String stringId;

        /** ギターid */
        @Column(name = "guitar_id")
    public String guitarId;

        /** 交換フラグ */
        @Column(name = "is_exchanged")
    public Boolean isExchanged;

        /** 削除フラグ */
        @Column(name = "is_deleted")
    public Boolean isDeleted;

        /** バージョン */
        @Version
        @Column(name = "version")
    public Integer version;

        /** 登録日時 */
        @Column(name = "created_at")
    public LocalDateTime createdAt;

        /** 更新日時 */
        @Column(name = "updated_at")
    public LocalDateTime updatedAt;
}