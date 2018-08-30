package com.example.boot01.controller;


import com.example.boot01.config.WeChatConfig;
import com.example.boot01.domian.JsonData;
import com.example.boot01.mapper.VideoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {


    @Autowired
    private WeChatConfig weChatConfig;

    @GetMapping("test")
    public String  test(){
        return "hello nihao122 ";
    }

    @GetMapping("test_config")
    public JsonData  test1(){

        System.out.println(weChatConfig.getAppid());
        return JsonData.buildSuccess(weChatConfig.getAppid());
    }

    @Autowired
    private VideoMapper videoMapper;

    @GetMapping("test_db")
    public Object  test_DB(){

        return videoMapper.findAll();
    }



}
