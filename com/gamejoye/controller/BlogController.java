package com.gamejoye.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gamejoye.pojo.Blog;
import com.gamejoye.service.BlogService;
import com.gamejoye.util.BlogUtils;
import com.gamejoye.util.FileUtils;
import com.gamejoye.util.RegexUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.util.*;

import com.gamejoye.constant.URLConstants;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


@RequestMapping("blog")
@Controller
public class BlogController {

    @Autowired
    BlogService blogService;

    @RequestMapping(value="/name/{name}")
    @CrossOrigin(origins = {URLConstants.BLOG_URL, URLConstants.BLOG_ADMIN_URL}, allowCredentials = "true",maxAge = 3600)
    @ResponseBody
    public String selectBlogsByUserName(@PathVariable String name) throws IOException {
        System.out.println("name: " + name);
        List<Blog> blogList = blogService.selectAllbyName(name);
        String json = JSON.toJSONString(blogList);
        return json;
    }

    @RequestMapping(value = "/images",method = RequestMethod.POST)
    @CrossOrigin(origins = {URLConstants.BLOG_ADMIN_URL}, allowCredentials = "true")
    @ResponseBody
    public String uploadImages(MultipartHttpServletRequest request) throws Exception {
        final String[] content = {request.getParameterMap().get("content")[0]};
        Map<String, String> accessPaths = FileUtils.uploadFiles(request.getFileMap());
        accessPaths.forEach((key, value) -> {
            //正则替换
            content[0] = RegexUtils.replaceAll(key, value, content[0]);
        });
        return content[0];
    }

    @RequestMapping(method = RequestMethod.POST)
    @CrossOrigin(origins = {URLConstants.BLOG_ADMIN_URL}, allowCredentials = "true",maxAge = 3600)
    @ResponseBody
    public String addBlog(@RequestBody Map<String,Object> map) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String title = (String) map.get("title");
        String name = (String) map.get("name");
        String content = (String) map.get("content");
        List<String> tags = mapper.convertValue(
                map.getOrDefault("tags", new ArrayList<String>()),
                new TypeReference<List<String>>(){}
        );
        int ordered = (Integer)map.get("ordered");
        boolean isExist = blogService.selectByArticlename(title, name) != null;
        if(isExist) {
            return "";
        } else {
            content = BlogUtils.formConversion(content);
            Blog blog = new Blog(title, name, content, ordered, new JSONArray(tags));
            blogService.add(blog);
            System.out.println(blog);
            return JSON.toJSONString(blog);
        }
    }


    @RequestMapping(value = "/{blogId}", method = RequestMethod.DELETE)
    @CrossOrigin(origins = {URLConstants.BLOG_ADMIN_URL}, allowCredentials = "true",maxAge = 3600)
    @ResponseBody
    public String deleteBlog(@PathVariable Integer blogId) throws IOException {
        boolean isExist = blogService.selectById(blogId) != null;
        if(isExist) {
            blogService.delete(blogId);
            return "true";
        } else {
            return "false";
        }
    }
}
