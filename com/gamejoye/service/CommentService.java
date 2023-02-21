package com.gamejoye.service;

import com.gamejoye.mapper.CommentMapper;
import com.gamejoye.pojo.Comment;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "CommentService")
public class CommentService {
    @Autowired
    SqlSessionTemplate sqlSession;

    @Autowired
    CommentMapper commentMapper;
    public List<Comment> getAllComments(String name,int blogId) {
        List<Comment> comments = commentMapper.getAllComments(name,blogId);
        return comments;
    }

    public void commitComment(Comment comment) {
        commentMapper.commitComment(comment);
    }

    public void deleteComment(int commentId) {
        commentMapper.deleteComment(commentId);
    }
}
