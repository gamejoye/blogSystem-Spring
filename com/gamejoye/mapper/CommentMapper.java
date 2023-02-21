package com.gamejoye.mapper;

import com.gamejoye.pojo.Comment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CommentMapper {
    List<Comment> getAllComments(@Param("name")String name, @Param("blogId")int blogId);
    void commitComment(Comment comment);
    void deleteComment(int commentId);
}
