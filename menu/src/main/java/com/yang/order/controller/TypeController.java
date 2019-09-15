package com.yang.order.controller;

import com.yang.order.entity.Type;
import com.yang.order.mapper.TypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/type")
public class TypeController {
    @Autowired
    private TypeMapper typeMapper;

    @RequestMapping("/findById/{id}")
    public Type findById(@PathVariable("id") long id){
        return typeMapper.findById(id);
    }
    @RequestMapping("/findTypes")
    public List<Type> findTypes(){
        return typeMapper.findTypes();
    }

}
