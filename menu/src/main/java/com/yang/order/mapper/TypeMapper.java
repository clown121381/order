package com.yang.order.mapper;

import com.yang.order.entity.Type;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TypeMapper {
    public Type findById(long id);

    public List<Type> findTypes();
}
