package com.jiaheqi.jdbcdemo.controller;

import com.jiaheqi.jdbcdemo.dao.GirlRepository;
import com.jiaheqi.jdbcdemo.entity.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    /*
    查询所有
     */
    @GetMapping(value = "/girls")
    public List<Girl>girlList(){
        return girlRepository.findAll();
    }

    /*
    根据年龄查询
     */
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl>girlListByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }

    /*
    增加一条数据
     */
    @PostMapping(value = "/girladd")
    public Girl girlAdd(@RequestParam("cupsize") String cupsize
                        ,@RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setCupsize(cupsize);
        girl.setAge(age);
        return girlRepository.save(girl);

    }
    /*
    删除一条数据
     */
    @DeleteMapping("/girls/{id}")
    public String girlDelete(@PathVariable("id") Integer id){
        girlRepository.deleteById(id);
        return " delete success";

    }
    /*
    更新一条数据
     */
    @PutMapping("/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id
                           ,@RequestParam("age") Integer age
                           ,@RequestParam("cupsize") String cupsize){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupsize(cupsize);
        return girlRepository.save(girl);


    }

}
