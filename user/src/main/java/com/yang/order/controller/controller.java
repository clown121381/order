package com.yang.order.controller;

import com.yang.order.entity.User;
import com.yang.order.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class controller {

    @Autowired
    private UserMapper userMapper;

    @Value("${server.port}")
    private String port;

    @RequestMapping("/port")
    public String port(){ return port; }

    @GetMapping("/findById")
    public User findById(long id){
        return userMapper.findById(id);
    }

    @RequestMapping("/count")
    public int count(){
        return userMapper.count();
    }

    @GetMapping("/findAll")
    public List<User> findAll(int index,int limit){
        return userMapper.findAll(index, limit);
    }

    @PostMapping("/save")
    public void save(@RequestBody User user){
        userMapper.save(user);
    }

    @PostMapping("/update")
    public void update(@RequestBody User user){
        userMapper.update(user);
    }

    @GetMapping("/deleteById")
    public void delete(long id){
        userMapper.delete(id);
    }
}