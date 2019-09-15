package com.yang.order.feign;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("account")
public interface AccountFeign {

    @RequestMapping("/account/login")
    Object login(@RequestParam("username") String username,@RequestParam("password") String passwrod,@RequestParam("type") String type);
}
