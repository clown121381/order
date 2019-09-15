package com.yang.order.controller;

import com.yang.order.entity.Order;
import com.yang.order.entity.OrderVo;
import com.yang.order.entity.User;
import com.yang.order.feign.MenuFeign;
import com.yang.order.feign.OrderFeign;
import feign.Feign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderFeign orderFeign;

    @Autowired
    private MenuFeign menuFeign;

    @GetMapping("/findAllByUid")
    @ResponseBody
    public OrderVo findAllByUid(int page, int limit, HttpSession session){
        LinkedHashMap<String,Object> user = (LinkedHashMap<String, Object>) session.getAttribute("user");
        Integer id = (Integer) user.get("id");
        return new OrderVo(0,"",orderFeign.count(id.longValue()),orderFeign.findAllByUid(id.longValue(),(page-1)*limit,limit));
    }

    @GetMapping("/findById")
    public Order findById(long id){
        return orderFeign.findById(id);
    }

    @GetMapping("/order")
    public String toOrder(){
        return "order";
    }

    @GetMapping("/save")
    public String save(long mid,HttpSession session){
        Order order = new Order();
        LinkedHashMap<String,Object> user = (LinkedHashMap<String, Object>) session.getAttribute("user");
        order.setMenu(menuFeign.findById(mid));
        Integer id = (Integer) user.get("id");

        User user1 = new User();
        user1.setId(id);

        order.setUser(user1);
        order.setState(0);

        orderFeign.save(order);

        return "order";
    }

    @GetMapping("/findAllByState")
    @ResponseBody
    public OrderVo findByState(int page,int limit,HttpSession session){
        return new OrderVo(0,"",orderFeign.countByState(),orderFeign.findAllByState((page-1)*limit,limit,0));
    }

    @GetMapping("/updateState")
    public String updateState(long id){

        orderFeign.updateState(id);
        return "order_handler";
    }
}
