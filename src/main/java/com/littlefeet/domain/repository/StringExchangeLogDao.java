package com.littlefeet.domain.repository;

import com.littlefeet.domain.entity.StringExchangeLog;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;

/**
 */
@ConfigAutowireable
@Dao
public interface StringExchangeLogDao {

    /**
     * @param id
     * @return the StringExchangeLog entity
     */
    @Select
    StringExchangeLog selectById(String id);

    /**
     * @param id
     * @param version
     * @return the StringExchangeLog entity
     */
    @Select(ensureResult = true)
    StringExchangeLog selectByIdAndVersion(String id, Integer version);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(StringExchangeLog entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(StringExchangeLog entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(StringExchangeLog entity);
}