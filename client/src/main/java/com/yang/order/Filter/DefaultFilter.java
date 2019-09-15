package com.yang.order.Filter;

import com.yang.order.entity.Admin;
import com.yang.order.entity.User;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedHashMap;

@Component
@WebFilter(urlPatterns = {"/index","/"},filterName = "defaultFilter")
public class DefaultFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();
        LinkedHashMap<String,Object>  user = (LinkedHashMap)session.getAttribute("user");
        LinkedHashMap<String,Object>  admin = (LinkedHashMap)session.getAttribute("admin");

        if(admin == null && user == null){
            resp.sendRedirect("/account");
        }else{
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
