package com.yang.order.controller;

import com.netflix.client.http.HttpResponse;
import com.yang.order.entity.Admin;
import com.yang.order.entity.User;
import com.yang.order.feign.AccountFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountFeign accountFeign;

    @GetMapping("")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/login")
    public String login(HttpSession session, String username, String password, String type){
        Object obj =  accountFeign.login(username, password, type);

        if(obj == null){
            return "redirect:/account";
        }
        if("admin".equals(type)){
            session.setAttribute("admin",obj);
            return "main";
        }else if("user".equals(type)){
            session.setAttribute("user",obj);
            return "index";
        }else{

        }
        return "index";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/account";
    }

    @RequestMapping("/redirect/{path}")
    public String reddirect(@PathVariable("path") String path){
        return path;
    }

}
