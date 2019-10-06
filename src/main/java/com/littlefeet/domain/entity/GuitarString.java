package com.littlefeet.domain.entity;

  import org.seasar.doma.Column;
  import org.seasar.doma.Entity;
  import org.seasar.doma.Table;

/**
*
*/
@Entity
  @Table(name = "guitar_string")
public class GuitarString extends CommonEntity {

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