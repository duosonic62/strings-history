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
  @Table(name = "member")
public class Member {

    /** メンバーid */
    @Id
    @Column(name = "id")
  public String id;

    /** メンバー名 */
    @Column(name = "name")
  public String name;

    /** アクセストークン */
    @Column(name = "token")
  public String token;

    /** トークン有効期限 */
    @Column(name = "token_expired")
  public LocalDateTime tokenExpired;

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