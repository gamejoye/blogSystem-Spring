package com.gamejoye.controller;

import com.gamejoye.constant.URLConstants;
import com.gamejoye.util.FileUtils;
import com.gamejoye.util.RegexUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

@RequestMapping("files")
@Controller
public class FilesController {
    static final String localPath = URLConstants.localPath;
    static final String urlPath = URLConstants.URL_PATH;
    @RequestMapping(value = "/images/{id}.{type}")
    @CrossOrigin(origins = {URLConstants.BLOG_URL, URLConstants.BLOG_ADMIN_URL}, allowCredentials = "true")
    @ResponseBody
    public ResponseEntity<byte[]> getImg(@PathVariable String id, @PathVariable String type, HttpServletRequest request) throws Exception {
        String eTag = request.getHeader("If-None-Match");
        String curTag = "W/\""+id+"\"";
        if(eTag != null && eTag.equals(curTag)) {
            return new ResponseEntity<byte[]>(new HttpHeaders(), HttpStatus.NOT_MODIFIED);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        File file = new File(localPath+id+"."+type);
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bytes = fileInputStream.readAllBytes();
        headers.setContentLength(bytes.length);
        headers.setETag(curTag);
        headers.setLastModified(new Date().getTime());
        return new ResponseEntity<byte[]>(bytes, headers, HttpStatus.CREATED);
    }



    @RequestMapping(value = "/images",method = RequestMethod.POST)
    @CrossOrigin(origins = {URLConstants.BLOG_ADMIN_URL}, allowCredentials = "true")
    @ResponseBody
    public String uploadImages(MultipartHttpServletRequest request) throws Exception {
        final String[] content = {request.getParameterMap().get("content")[0]};
        Map<String, MultipartFile> multiFileMap = request.getFileMap();
        System.out.println("content: " + content[0]);
        multiFileMap.forEach((key, file) -> {
            //设置正则匹配规则
            //随机命名
            System.out.println("key" + key);
            String uuid = UUID.randomUUID().toString();
            String[] splits = file.getOriginalFilename().split("\\.");
            String newName = uuid + "." + splits[splits.length-1];
            String keyAfterTransform = urlPath + newName;
            //正则替换
            content[0] = RegexUtils.replaceAll(key, keyAfterTransform, content[0]);
            FileUtils.upload(file, localPath, newName);
        });
        //System.out.println(content[0]);
        return content[0];
    }

}
