package com.yang.order.mapper;

import com.yang.order.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface UserMapper {

    List<User> findAll(@Param("index") int index,@Param("limit") int limit);
    User findById(long id);
    void update(User user);
    void delete(long id);
    void save(User user);
    int count();
}
