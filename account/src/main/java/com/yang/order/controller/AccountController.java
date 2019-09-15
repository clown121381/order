package com.yang.order.controller;

import com.yang.order.entity.Admin;
import com.yang.order.mapper.AdminMapper;
import com.yang.order.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AdminMapper adminMapper;

    @GetMapping("/login")
    @ResponseBody
    public Object login(String username,String password,String type){
        Object obj = null;
        if("user".equals(type)){
            obj = userMapper.login(username, password);
        }else if("admin".equals(type)){
            obj = adminMapper.login(username, password);
        }
        return obj;
    }

}
