package com.gamejoye.controller;


import com.alibaba.fastjson.JSON;
import com.gamejoye.pojo.Blog;
import com.gamejoye.service.Service;
import com.gamejoye.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RequestMapping("user")
@Controller
public class User {
    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    @RequestMapping(value = "/introduction", produces="application/json;charset=UTF-8")
    @ResponseBody
    public String selectIntroduction(String username, HttpServletRequest request, HttpServletResponse response) throws IOException {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService service = (UserService)app.getBean("userService");
        String aboutMe = service.getAboutme(username);
        return aboutMe;
    }

    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    @RequestMapping(value = "/edit", produces="application/json;charset=UTF-8")
    @ResponseBody
    public String updateIntroduction(@RequestBody Map<String,String> map,HttpServletRequest request, HttpServletResponse response) throws IOException {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService service = (UserService)app.getBean("userService");
        String username = map.get("username");
        String aboutMe = map.get("aboutMe");
        System.out.println(username);
        System.out.println(aboutMe);
        service.setAboutMe(aboutMe,username);
        return "true";
    }
}
