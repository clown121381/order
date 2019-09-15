package com.yang.order.mapper;

import com.yang.order.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {
    public void save(Order order);
    public List<Order> findAllByUid(@Param("uid") long uid,@Param("index") int index, @Param("limit") int limit);
    public int count(long uid);
    public Order findById(long id);
    public List<Order> findAllByState(@Param("state") long state,@Param("index") int index, @Param("limit") int limit);
    public void updateState(long id);

    int countByState();
//    public int update(Order order);
//    public void deleteById(long id);
}
