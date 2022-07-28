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
    @RequestMapping(value="/all", produces="application/json;charset=UTF-8")
    @ResponseBody
    public String selectAllBlog(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        Service service = (Service)app.getBean("service");
        List<Blog> blogList = service.selectAll();
        String json = JSON.toJSONString(blogList);
        return json;
    }

    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    @RequestMapping(value="/byName", produces="application/json;charset=UTF-8")
    @ResponseBody
    public String selectBlogByName(String username,HttpServletRequest request, HttpServletResponse response) throws IOException {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        Service service = (Service)app.getBean("service");
        if(username.equals("")){return "not login";}
        List<Blog> blogList = service.selectAllbyName(username);
        String json = JSON.toJSONString(blogList);
        return json;
    }

    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    @RequestMapping(value="/title", produces="application/json;charset=UTF-8")
    @ResponseBody
    public String selectBlogBytitle(String titles,HttpServletRequest request, HttpServletResponse response) throws IOException {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        Service service = (Service)app.getBean("service");
        Blog blog = service.selectByArticlename(titles);
        String json = JSON.toJSONString(blog);
        return json;
    }

    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    @RequestMapping(value="/add",method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public String addBlog(@RequestBody Map<String,String> map,HttpServletRequest request, HttpServletResponse response) throws IOException {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        String title = map.get("title");
        String username = map.get("username");
        String content = map.get("content");
        int ordered = Integer.parseInt(map.get("order"));
        Service service = (Service)app.getBean("service");
        boolean isExist = service.selectByArticlename(title) != null;
        if(isExist) {
            return "This blog already exists, please change it to a new blog name";
        } else {
            Blog blog = new Blog(title,username,content,ordered);
            service.add(blog);
            return "successfully added";
        }
    }
}
