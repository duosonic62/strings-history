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
public class Member extends CommonEntity {

      /**
      * メンバー名
      */
      @Column(name = "name")
      public String name;

      /**
      * アクセストークン
      */
      @Column(name = "token")
      public String token;

      /**
      * トークン有効期限
      */
      @Column(name = "token_expired")
      public LocalDateTime tokenExpired;
}