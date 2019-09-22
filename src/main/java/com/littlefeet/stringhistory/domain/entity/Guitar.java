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
  @Table(name = "guitar")
public class Guitar extends CommonEntity {

      /**
      * メンバーid(外部キー)
      */
      @Column(name = "member_id")
      public String memberId;

      /**
      * ギター名
      */
      @Column(name = "name")
      public String name;

      /**
      * 説明
      */
      @Column(name = "description")
      public String description;

      /**
      * ギター機種
      */
      @Column(name = "body_type")
      public String bodyType;

      /**
      * メーカー
      */
      @Column(name = "maker")
      public String maker;

      /**
      * ギター画像
      */
      @Column(name = "image_url")
      public String imageUrl;
}