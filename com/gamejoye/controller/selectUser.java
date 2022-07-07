package com.gamejoye.controller;

import com.alibaba.fastjson.JSON;
import com.gamejoye.pojo.Blog;
import com.gamejoye.pojo.User;
import com.gamejoye.service.Service;
import com.gamejoye.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RequestMapping("users")
@Controller
public class selectUser {
    @CrossOrigin(origins = "http://112.74.55.177:3000", allowCredentials = "true")
    @RequestMapping(value="/level")
    @ResponseBody
    public String selectUserByLevel(String level, HttpServletRequest request, HttpServletResponse response) throws IOException {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService)app.getBean("userService");
        List<User> userList = userService.selectByLevel(Integer.parseInt(level));
        String json = JSON.toJSONString(userList);
        return json;
    }
}
