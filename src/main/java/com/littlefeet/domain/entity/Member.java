package com.littlefeet.domain.entity;

  import org.seasar.doma.Column;
  import org.seasar.doma.Entity;
  import org.seasar.doma.Table;

  import java.time.LocalDateTime;

/**
*
*/
@Entity
  @Table(name = "member")
public class Member extends CommonEntity {

      /**
      * 外部認証紐付け用uid
      */
      @Column(name = "uid")
      public String uid;

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