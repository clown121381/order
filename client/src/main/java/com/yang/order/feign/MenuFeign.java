package com.yang.order.feign;

import com.yang.order.entity.Menu;
import com.yang.order.entity.Type;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@FeignClient(value="menu")
public interface MenuFeign {
    @GetMapping("/menu/findAll/{index}/{limit}")
    public List<Menu> findAll(@PathVariable("index") int index,@PathVariable("limit") int limit);

    @GetMapping("/menu/count")
    public int count();

    @GetMapping("/menu/deleteById")
    public void deleteById(@RequestParam("id") long id);

    @RequestMapping("/type/findTypes")
    public List<Type> findTypes();

    @RequestMapping("/menu/save")
    public void save(Menu menu);

    @RequestMapping("/menu/findById")
    public Menu findById(@RequestParam("id") long id);

    @RequestMapping("/menu/update")
    public void update(Menu menu);
}
