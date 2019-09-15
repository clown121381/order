package com.yang.order.mapper;

import com.yang.order.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    User login(@Param("username") String username,@Param("password") String password);
}
