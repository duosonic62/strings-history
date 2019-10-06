package com.littlefeet.domain.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Version;

import java.time.LocalDateTime;

@Entity(listener = CustomEntityListener.class)
public abstract class CommonEntity {

  @Id
  @Column(name = "id")
  public java.lang.String id;

  /**
   *
   */
  @Column(name = "created_at")
  public LocalDateTime createdAt;

  /**
   *
   */
  @Column(name = "updated_at")
  public LocalDateTime updatedAt;

  /**
   *
   */
  @Column(name = "is_deleted")
  public Boolean isDeleted;

  /**
   *
   */
  @Version
  @Column(name = "version")
  public Long version;
}
