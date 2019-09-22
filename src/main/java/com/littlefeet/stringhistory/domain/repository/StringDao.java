package com.littlefeet.stringhistory.domain.repository;

import com.littlefeet.stringhistory.domain.entity.String;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

/**
 */
@Dao
public interface StringDao {

    /**
     * @param id
     * @return the String entity
     */
    @Select
    String selectById(String id);

    /**
     * @param id
     * @param version
     * @return the String entity
     */
    @Select(ensureResult = true)
    String selectByIdAndVersion(String id, Integer version);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(String entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(String entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(String entity);
}