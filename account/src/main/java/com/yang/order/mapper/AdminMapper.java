package com.yang.order.mapper;

import com.yang.order.entity.Admin;
import com.yang.order.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdminMapper {
    Admin login(@Param("username") String username, @Param("password") String password);
}
