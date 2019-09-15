package com.yang.order.feign;

import com.yang.order.entity.Menu;
import com.yang.order.entity.Type;
import com.yang.order.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value="user")
public interface UserFeign {
    @GetMapping("/user/findAll")
    public List<User> findAll(@RequestParam("index") int index, @RequestParam("limit") int limit);

    @GetMapping("/user/deleteById")
    public void deleteById(@RequestParam("id") long id);

    @RequestMapping("/user/save")
    public void save(User user);

    @RequestMapping("/user/count")
    public int count();

    @RequestMapping("/user/findById")
    public User findById(@RequestParam("id") long id);

}
