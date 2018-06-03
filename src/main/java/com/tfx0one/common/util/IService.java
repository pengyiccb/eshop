package com.tfx0one.common.util;

import java.util.List;

public interface IService<T> {

    /**
     * 根据实体类不为null的字段进行查询,条件全部使用=号and条件
     */
    public List<T> select(T record);

    /**
     * 根据实体类不为null的字段查询总数,条件全部使用=号and条件
     */
    public int selectCount(T record);

    T selectByPrimaryKey(Object key);

    T selectOne(T entity);

    int save(T entity);

    int delete(Object key);

    int updateAll(T entity);

    int updateNotNull(T entity);

    List<T> selectByExample(Object example);

    //TODO 其他...
}

