package com.gamejoye.controller;

import com.alibaba.fastjson.JSON;
import com.gamejoye.pojo.Blog;
import com.gamejoye.pojo.User;
import com.gamejoye.service.Service;
import com.gamejoye.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("function")
public class function {

    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true", maxAge = 3600)
    @RequestMapping(value = "/login",method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public String login(@RequestBody Map<String,String> map, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        String username = map.get("username");
        String password = map.get("password");
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService)app.getBean("userService");
        boolean isExist = userService.login(username, password);
        if(!isExist) {
            //不在用户，跳转回到登陆页面
            return "failed";
        } else {
            //存在用户
            User user = userService.selectOne(username);
            return  JSON.toJSONString(user);
        }
    }

    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true", maxAge = 3600)
    @RequestMapping(value = "/register",method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public String register(@RequestBody Map<String,String> map, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        String username = map.get("username");
        String password = map.get("password");
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService)app.getBean("userService");
        boolean isExist = userService.register(username);
        if(isExist) {
            //存在用户，无法注册，返回错误标识
            return "failed";
        } else {
            //不存在用户，可以注册
            //将用户添加进数据库
            userService.add(new User(username,password));
            return "success";
        }
    }
    
}
