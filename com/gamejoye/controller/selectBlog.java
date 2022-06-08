package com.gamejoye.controller;


import com.alibaba.fastjson.JSON;
import com.gamejoye.pojo.Blog;
import com.gamejoye.service.Service;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RequestMapping("blogs")
@Controller
public class selectBlog {
    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true",maxAge = 3600)
    @RequestMapping(value="/all")
    @ResponseBody
    public String selectAllBlog(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        Service service = (Service)app.getBean("service");
        List<Blog> blogList = service.selectAll();
        String json = JSON.toJSONString(blogList);
        return json;
    }

    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    @RequestMapping(value="/byName")
    @ResponseBody
    public String selectBlogByName(String username,HttpServletRequest request, HttpServletResponse response) throws IOException {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        Service service = (Service)app.getBean("service");
        List<Blog> blogList = service.selectAllbyName(username);
        String json = JSON.toJSONString(blogList);
        return json;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/article_name")
    @ResponseBody
    public String selectBlogByArticle_name(String article_name,HttpServletRequest request, HttpServletResponse response) throws IOException {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        Service service = (Service)app.getBean("service");
        Blog blog = service.selectByArticlename(article_name);
        String json = JSON.toJSONString(blog);
        return json;
    }

}
