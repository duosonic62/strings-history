package com.littlefeet.domain.entity;

  import org.seasar.doma.Column;
  import org.seasar.doma.Entity;
  import org.seasar.doma.Table;

/**
*
*/
@Entity
  @Table(name = "string_exchange_log")
public class StringExchangeLog extends CommonEntity {

      /**
      * 弦id
      */
      @Column(name = "string_id")
      public String stringId;

      /**
      * ギターid
      */
      @Column(name = "guitar_id")
      public String guitarId;

      /**
      * 交換フラグ
      */
      @Column(name = "is_exchanged")
      public Boolean isExchanged;
}