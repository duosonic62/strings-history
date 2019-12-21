package com.littlefeet.domain.repository;

import com.littlefeet.domain.entity.Guitar;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

/**
 *
 */
@ConfigAutowireable
@Dao
public interface GuitarDao {

  /**
   * @param id
   * @return the Guitar entity
   */
  @Select
  Guitar selectById(String id);

  @Select
  List<Guitar> findByMemberId(String memberId);

  @Select
  Guitar findByIdAndMemberId(String id, String memberId);

  /**
   * @param id
   * @param version
   * @return the Guitar entity
   */
  @Select(ensureResult = true)
  Guitar selectByIdAndVersion(String id, Integer version);

  /**
   * @param entity
   * @return affected rows
   */
  @Insert
  int insert(Guitar entity);

  /**
   * @param entity
   * @return affected rows
   */
  @Update
  int update(Guitar entity);

  /**
   * @param entity
   * @return affected rows
   */
  @Delete
  int delete(Guitar entity);
}