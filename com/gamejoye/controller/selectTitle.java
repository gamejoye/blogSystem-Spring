package com.gamejoye.controller;

import com.alibaba.fastjson.JSON;
import com.gamejoye.pojo.Blog;
import com.gamejoye.service.Service;
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

@RequestMapping("titles")
@Controller
public class selectTitle {
    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true",maxAge = 3600)
    @RequestMapping(value="/byName")
    @ResponseBody
    public String selectAllBlog(String username,HttpServletRequest request, HttpServletResponse response) throws IOException {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        Service service = (Service)app.getBean("service");
        List<String> titlesList = service.selectTitles(username);
        String json = JSON.toJSONString(titlesList);
        return json;
    }
}
