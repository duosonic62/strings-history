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
  @Table(name = "string")
public class String {

    /** 弦id */
    @Id
    @Column(name = "id")
  public String id;

    /** 弦名 */
    @Column(name = "name")
  public String name;

    /** 説明 */
    @Column(name = "description")
  public String description;

    /** メーカー */
    @Column(name = "maker")
  public String maker;

    /** 細い弦のゲージ */
    @Column(name = "thin_gauge")
  public Integer thinGauge;

    /** 太い弦のゲージ */
    @Column(name = "thick_gauge")
  public Integer thickGauge;

    /** 商品URL */
    @Column(name = "url")
  public String url;

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