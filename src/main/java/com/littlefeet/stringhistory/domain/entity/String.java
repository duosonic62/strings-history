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
public class String extends CommonEntity {

      /**
      * 弦名
      */
      @Column(name = "name")
      public String name;

      /**
      * 説明
      */
      @Column(name = "description")
      public String description;

      /**
      * メーカー
      */
      @Column(name = "maker")
      public String maker;

      /**
      * 細い弦のゲージ
      */
      @Column(name = "thin_gauge")
      public Short thinGauge;

      /**
      * 太い弦のゲージ
      */
      @Column(name = "thick_gauge")
      public Short thickGauge;

      /**
      * 商品URL
      */
      @Column(name = "url")
      public String url;
}