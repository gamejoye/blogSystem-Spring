package com.gamejoye.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gamejoye.constant.URLConstants;
import com.gamejoye.pojo.UserInformation;
import com.gamejoye.service.UserInformationService;
import com.gamejoye.service.UserPrivacyService;
import com.gamejoye.util.FileUtils;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RequestMapping("user")
@Controller
public class UserController {
    @Autowired
    UserPrivacyService userPrivacyService;
    @Autowired
    UserInformationService userInformationService;
    @RequestMapping(value = "/authentication", method = RequestMethod.POST)
    @CrossOrigin(origins = {URLConstants.BLOG_ADMIN_URL}, allowCredentials = "true")
    @ResponseBody
    public String userAuthentication(@RequestBody Map<String, String> map, HttpSession session) throws IOException {
        String name = map.get("name");
        String password = map.get("password");
        boolean isExist = userPrivacyService.login(name, password);
        JSONObject json = new JSONObject();
        if(isExist) {
            String token = UUID.randomUUID().toString();
            json.put("code", 200);
            json.put("token", token);
            json.put("userInfo", userInformationService.getInfo(name));
            session.setAttribute(token, name);
        } else {
            json.put("code", 401);
        }
        System.out.println("json: " + json);
        return JSON.toJSONString(json);
    }

    @RequestMapping(value = "/{token}", method = RequestMethod.DELETE)
    @CrossOrigin(origins = {URLConstants.BLOG_ADMIN_URL}, allowCredentials = "true")
    @ResponseBody
    public void logoutUser(@PathVariable String token, HttpSession session) throws IOException {
        session.removeAttribute(token);
    }

    @RequestMapping(value = "/introduction/{value}")
    @CrossOrigin(origins = {URLConstants.BLOG_URL, URLConstants.BLOG_ADMIN_URL}, allowCredentials = "true")
    @ResponseBody
    public String selectIntroductionByToken(@PathVariable String value, HttpSession session) throws IOException {
        String name = value.length() <= 20
                ? value
                : (String)session.getAttribute(value);
        System.out.println("getUserIntroduction!!!!");
        System.out.println(name);
        UserInformation userInformation = userInformationService.getInfo(name);
        System.out.println(userInformation);
        return JSON.toJSONString(userInformation);
    }

    @RequestMapping(value = "/introduction/{name}", method = RequestMethod.PUT)
    @CrossOrigin(origins = {URLConstants.BLOG_ADMIN_URL}, allowCredentials = "true")
    @ResponseBody
    public String updateIntroduction(@RequestBody Map<String,String> map, @PathVariable String name) throws IOException {
        String res = "false";
        try {
            String avatarUrl = map.get("avatarUrl");
            String aboutMe = map.get("aboutMe");
            String sex = map.get("sex");
            String address = map.get("address");
            String birthday = map.get("birthday");
            UserInformation userInformation = new UserInformation(avatarUrl, name, sex, address, birthday, aboutMe);
            userInformationService.updateUserInfo(userInformation);
            res = "true";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @RequestMapping(value = "/image", method = RequestMethod.POST)
    @CrossOrigin(origins = {URLConstants.BLOG_ADMIN_URL}, allowCredentials = "true")
    @ResponseBody
    public String uploadImage(MultipartHttpServletRequest request) {
        String name = request.getParameterMap().get("name")[0];
        Map<String, String> accessPaths = FileUtils.uploadFiles(request.getFileMap());
        String avatarUrl = "";
        for(String accessPath: accessPaths.values()) avatarUrl = accessPath;
        userInformationService.updateAvatarUrl(name, avatarUrl);
        return avatarUrl;
    }
}
