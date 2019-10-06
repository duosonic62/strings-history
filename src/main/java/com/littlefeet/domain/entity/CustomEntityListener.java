package com.littlefeet.domain.entity;


import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

import java.time.LocalDateTime;
import java.util.UUID;

public class CustomEntityListener<ENTITY> implements EntityListener<ENTITY> {

  @Override
  public void preInsert(ENTITY entity, PreInsertContext<ENTITY> context) {
    LocalDateTime now = LocalDateTime.now();
    // 共通で代入する値をセットする
    CommonEntity insertEntity = (CommonEntity) entity;
    insertEntity.id = UUID.randomUUID().toString();
    insertEntity.createdAt = now;
    insertEntity.updatedAt = now;
    insertEntity.isDeleted = false;
  }

  @Override
  public void preUpdate(ENTITY entity, PreUpdateContext<ENTITY> context) {
    CommonEntity updateEntity = (CommonEntity) entity;

    if (context.getMethod().getName().startsWith("delete")) {
      // 論理削除
      updateEntity.updatedAt = LocalDateTime.now();
      updateEntity.isDeleted = true;
    } else {
      // 更新
      updateEntity.updatedAt = LocalDateTime.now();
    }
  }
}
