package com.gamejoye.controller;


import com.gamejoye.constant.URLConstants;
import com.gamejoye.pojo.Comment;
import com.gamejoye.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RequestMapping("blog/{blogId}/comment")
@Controller
public class CommentController {
    @Autowired
    CommentService cs;

    @RequestMapping(value="/all")
    @CrossOrigin(origins = {URLConstants.BLOG_URL, URLConstants.BLOG_ADMIN_URL}, allowCredentials = "true",maxAge = 3600)
    @ResponseBody
    public List<Comment> getAllComments(String name, @PathVariable Integer blogId) {
        List<Comment> comments = cs.getAllComments(name,blogId);
        return comments;
    }

    @RequestMapping(method = RequestMethod.POST)
    @CrossOrigin(origins = {URLConstants.BLOG_ADMIN_URL}, allowCredentials = "true",maxAge = 3600)
    @ResponseBody
    public String postComment(@RequestBody Map<String,String> map) {
        Comment comment = new Comment(
                map.get("name"),
                Integer.parseInt(map.get("blogId")),
                map.get("content"),
                map.get("commentDay")
        );
        cs.commitComment(comment);
        return "ok";
    }

    @RequestMapping(value = "/{commentId}", method = RequestMethod.DELETE)
    @CrossOrigin(origins = {URLConstants.BLOG_ADMIN_URL}, allowCredentials = "true",maxAge = 3600)
    @ResponseBody
    public String deleteComment(@PathVariable Integer commentId) {
        String res = "false";
        try {
            cs.deleteComment(commentId);
            res = "true";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
