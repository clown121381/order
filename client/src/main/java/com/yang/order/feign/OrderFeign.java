package com.yang.order.feign;

import com.yang.order.entity.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("order")
public interface OrderFeign {
    @GetMapping("/order/findAllByUid")
    public List<Order> findAllByUid(@RequestParam("uid") long uid,@RequestParam("index") int index, @RequestParam("limit") int limit);

//    @GetMapping("/order/deleteById")
//    public void deleteById(@RequestParam("id") long id);

    @RequestMapping("/order/save")
    public void save(Order order);

    @GetMapping("/order/count")
    public int count(@RequestParam("uid") long uid);

    @RequestMapping("/order/findById")
    public Order findById(@RequestParam("id") long id);


    @GetMapping("/order/findAllByState")
    List<Order> findAllByState(@RequestParam("index") int index,@RequestParam("limit") int limit,@RequestParam("state") int state);

    @GetMapping("/order/updateState")
    void updateState(@RequestParam("id") long id);

    @GetMapping("/order/countByState")
    int countByState();
}
