package com.yang.order.controller;

import com.yang.order.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.yang.order.entity.Order;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderMapper orderMapper;

    @Value("${server.port}")
    private String port;

    @RequestMapping("/port")
    private String index(){
        return "order的端口是"+port;
    }

    @PostMapping("/order")
    public void order(@RequestBody Order order){
        orderMapper.save(order);
    }
    @GetMapping("/findAllByUid")
    public List<Order> findAllByUid(long uid,int index,int limit){
        return orderMapper.findAllByUid(uid,index,limit);
    }

    @GetMapping("/count")
    public int count(long uid){
        return orderMapper.count(uid);
    }

    @GetMapping("/findById")
    public Order findById(long id){
        return orderMapper.findById(id);
    }

    @PostMapping("/save")
    public void save(@RequestBody Order order){
        orderMapper.save(order);
    }

    @GetMapping("/findAllByState")
    public List<Order> findByState(int index,int limit,int state){
        return orderMapper.findAllByState(state,index,limit);
    }

    @GetMapping("/updateState")
    public void updateState(long id){
        orderMapper.updateState(id);
    }

    @GetMapping("/countByState")
    public int countByState(){
        return orderMapper.countByState();
    }
}
