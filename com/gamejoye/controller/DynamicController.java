package com.gamejoye.controller;


import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gamejoye.constant.URLConstants;
import com.gamejoye.pojo.Talk;
import com.gamejoye.pojo.UserInformation;
import com.gamejoye.service.DynamicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("dynamic/{name}")
@Controller
public class DynamicController {
    @Autowired
    DynamicService dynamicService;


    @RequestMapping(value = "/talk/all")
    @CrossOrigin(origins = {URLConstants.BLOG_URL, URLConstants.BLOG_ADMIN_URL}, allowCredentials = "true")
    @ResponseBody
    public String getAllTalk(@PathVariable String name) {
        List<Talk> talks = dynamicService.getAllTalksByName(name);
        return JSON.toJSONString(talks);
    }

    @RequestMapping(value = "/talk", method = RequestMethod.POST)
    @CrossOrigin(origins = {URLConstants.BLOG_ADMIN_URL}, allowCredentials = "true")
    @ResponseBody
    public String postTalk(@PathVariable String name, @RequestBody Map<String, Object> map) {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(map.get("userInfo"));
        UserInformation userInformation = mapper.convertValue(
                map.get("userInfo"),
                new TypeReference<UserInformation>(){}
        );
        System.out.println(map);
        Talk talk = new Talk(
                (Integer) (map.get("id")),
                userInformation,
                map.get("content").toString(),
                map.get("releaseTime").toString(),
                map.get("mood").toString()
        );
        System.out.println("pre: \n" + talk);
        dynamicService.postTalk(talk);
        System.out.println("after: \n" + talk);
        return JSON.toJSONString(talk);
    }

    @RequestMapping(value = "/talk/{id}", method = RequestMethod.DELETE)
    @CrossOrigin(origins = {URLConstants.BLOG_ADMIN_URL}, allowCredentials = "true")
    @ResponseBody
    public String deleteTalkById(@PathVariable Integer id) {
        String res = "false";
        try {
            dynamicService.deleteTalk(id);
            res = "true";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @RequestMapping("/essay/all")
    @CrossOrigin(origins = {URLConstants.BLOG_URL, URLConstants.BLOG_ADMIN_URL}, allowCredentials = "true")
    @ResponseBody
    public String getAllEssay(@PathVariable String name) {
        return "";
    }

    @RequestMapping(value = "/essay", method = RequestMethod.POST)
    @CrossOrigin(origins = {URLConstants.BLOG_ADMIN_URL}, allowCredentials = "true")
    @ResponseBody
    public String postEssay(@PathVariable String name, @RequestBody Map<String, String> map) {
        return "";
    }

    @RequestMapping(value = "/essay/{id}", method = RequestMethod.DELETE)
    @CrossOrigin(origins = {URLConstants.BLOG_ADMIN_URL}, allowCredentials = "true")
    @ResponseBody
    public String deleteEssayById(@PathVariable String name, @PathVariable Integer id) {
        return "";
    }
}
