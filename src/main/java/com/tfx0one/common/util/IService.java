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

    //说明：根据主键字段进行删除，方法参数必须包含完整的主键属性
    int deleteByPrimaryKey(Object key);

    //说明：根据主键更新实体全部字段，null值会被更新
    int updateByPrimaryKey(T entity);

    int updateNotNull(T entity);

    List<T> selectByExample(Object example);

    //TODO 其他...
}

