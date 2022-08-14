package com.example.sb_mp.Controller.test;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/worlds")
public class world {

    //浏览器输入http://localhost:8080/world ，会看到 hello world!
    //如果端口是80，那么直接localhost/world 就行
    @RequestMapping("/world2")
    public String hi(){
        System.out.println("控制台spring boot 打印 \"hello world! \"...");
        return "hello world! ";

    }
}
