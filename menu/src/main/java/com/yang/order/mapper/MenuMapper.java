package com.yang.order.mapper;

import com.yang.order.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface MenuMapper {
    public List<Menu> findAll(@Param("index") int index, @Param("limit") int limit);
    public int count();
    public Menu findById(long id);
    public void save(Menu menu);
    public int update(Menu menu);
    public void deleteById(long id);
}
