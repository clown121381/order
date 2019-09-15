package com.yang.order.controller;

import com.yang.order.entity.Menu;
import com.yang.order.entity.MenuVo;
import com.yang.order.entity.Type;
import com.yang.order.feign.MenuFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuFeign menuFeign;

    @GetMapping("/findAll")
    @ResponseBody
    public MenuVo findAll(@RequestParam("page") int page, @RequestParam("limit") int limit){
        return new MenuVo(0,"", menuFeign.count(), menuFeign.findAll(((page-1)*limit),limit));
    }

    @RequestMapping("/deleteById")
    public String deleteById(long id){
        menuFeign.deleteById(id);
        return "/account/redirect/menu_manage";
    }

    @RequestMapping("/menu_add")
    public ModelAndView findTypes(){
        List<Type> types = menuFeign.findTypes();
        ModelAndView view = new ModelAndView("/menu_add");
        view.addObject("list",types);
        return view;
    }

    @PostMapping("/save")
    public String save(Menu menu){
        menuFeign.save(menu);
        return "/account/redirect/menu_manage";
    }

    @GetMapping("/toupdatepage")
    public ModelAndView youpdatepage(@RequestParam("id") int id){
        ModelAndView view = new ModelAndView("menu_update");
        view.addObject("list",menuFeign.findTypes());
        view.addObject("menu",menuFeign.findById(id));
        return view;
    }

    @RequestMapping("/update")
    public String update(Menu menu){
        menuFeign.update(menu);
        return "/account/redirect/menu_manage";
    }

}
