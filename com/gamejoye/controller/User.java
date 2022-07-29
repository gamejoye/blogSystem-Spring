package com.gamejoye.controller;


import com.alibaba.fastjson.JSON;
import com.gamejoye.pojo.Blog;
import com.gamejoye.pojo.UInfo;
import com.gamejoye.service.Service;
import com.gamejoye.service.UInfoService;
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
    public UInfo selectIntroduction(String username, HttpServletRequest request, HttpServletResponse response) throws IOException {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UInfoService service = (UInfoService)app.getBean("uinfoService");
        UInfo uInfo = service.getInfo(username);
        return uInfo;
    }

    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    @RequestMapping(value = "/edit", produces="application/json;charset=UTF-8")
    @ResponseBody
    public String updateIntroduction(@RequestBody Map<String,String> map,HttpServletRequest request, HttpServletResponse response) throws IOException {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UInfoService service = (UInfoService)app.getBean("uinfoService");
        String username = map.get("username");
        String aboutMe = map.get("aboutMe");
        String sex = map.get("sex");
        String address = map.get("addresss");
        String birthday = map.get("birthday");
        if(aboutMe != null) {
            service.setAboutMe(aboutMe,username);
        } else if(sex != null) {
            service.setSex(sex,username);
        } else if(address != null) {
            service.setAddress(address,username);
        } else if(birthday != null) {
            service.setBirthday(birthday,username);
        } else {
            return "更改字段不存在...";
        }
        return "true";
    }
}
