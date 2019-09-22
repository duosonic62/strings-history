package com.littlefeet.stringhistory.domain.repository;

import com.littlefeet.stringhistory.domain.entity.Member;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

/**
 */
@Dao
public interface MemberDao {

    /**
     * @param id
     * @return the Member entity
     */
    @Select
    Member selectById(String id);

    /**
     * @param id
     * @param version
     * @return the Member entity
     */
    @Select(ensureResult = true)
    Member selectByIdAndVersion(String id, Integer version);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(Member entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(Member entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(Member entity);
}