package com.yang.order.controller;

import com.yang.order.entity.User;
import com.yang.order.entity.UserVo;
import com.yang.order.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserFeign userFeign;

    @GetMapping("/findAll")
    @ResponseBody
    public UserVo findAll(@RequestParam("page") int index, @RequestParam("limit") int limit){
        return new UserVo(0,"",userFeign.count(),userFeign.findAll((index-1)*limit,limit));
    }

    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") long id){
          userFeign.deleteById(id);
        return "redirect:/user/user_manage";
    }

    @RequestMapping("/findById")
    @ResponseBody
    public User findById(@RequestParam("id") long id){
        return userFeign.findById(id);
    }

    @RequestMapping("/user_manage")
    public String userManager(){
        return "/user_manage";
    }

    @RequestMapping("/user_add")
    public String add(){
        return "user_add";
    }

    @RequestMapping("/save")
    public String save(User user){
        userFeign.save(user);
        return "redirect:/user/user_manage";
    }
}
