package com.littlefeet.domain.repository;

import com.littlefeet.domain.entity.GuitarString;
  import org.seasar.doma.Dao;
  import org.seasar.doma.Delete;
  import org.seasar.doma.Insert;
  import org.seasar.doma.Select;
  import org.seasar.doma.Update;
  import org.seasar.doma.boot.ConfigAutowireable;

/**
*
*/
  @ConfigAutowireable
@Dao
public interface GuitarStringDao {

  /**
    * @param id
  * @return the GuitarString entity
  */
  @Select
  GuitarString selectById(String id);

  /**
    * @param id
  * @param version
  * @return the GuitarString entity
  */
  @Select(ensureResult = true)
  GuitarString selectByIdAndVersion(String id, Integer version);

/**
* @param entity
* @return affected rows
*/
@Insert
int insert(GuitarString entity);

/**
* @param entity
* @return affected rows
*/
@Update
int update(GuitarString entity);

/**
* @param entity
* @return affected rows
*/
@Delete
int delete(GuitarString entity);
}