package com.yang.order.controller;

import com.yang.order.entity.Menu;
import com.yang.order.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Value("${server.port}")
    private String port;

    @Autowired
    private MenuMapper menuMapper;

    @RequestMapping("/port")
    public String port(){
        return "menu的端口为"+port;
    }
    @RequestMapping("/findAll/{index}/{limit}")
    public List<Menu> findAll(@PathVariable("index") int index,@PathVariable("limit") int limit){
        return menuMapper.findAll(index,limit);
    }
    @RequestMapping("/find")
    public Menu findById(){
        return menuMapper.findById(1);
    }

    @RequestMapping("/count")
    public int count(){
        return menuMapper.count();
    }

    @GetMapping("/deleteById")
    public void deleteById(@RequestParam("id") long id){
        menuMapper.deleteById(id);
    }

    @PostMapping("/save")
    public void save(@RequestBody Menu menu){
        menuMapper.save(menu);
    }

    @GetMapping("/findById")
    public Menu findById(@RequestParam("id") long id){
        return menuMapper.findById(id);
    }

    @RequestMapping("/update")
    public void update(@RequestBody Menu menu){
        int a = menuMapper.update(menu);
    }
}
