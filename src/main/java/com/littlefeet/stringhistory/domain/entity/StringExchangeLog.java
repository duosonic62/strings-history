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