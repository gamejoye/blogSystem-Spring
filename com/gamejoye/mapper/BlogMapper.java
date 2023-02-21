package com.gamejoye.mapper;

import com.gamejoye.pojo.Blog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BlogMapper {

    List<Blog> selectAll();
    void add(Blog blog);
    Blog selectByArticlename(@Param("title") String title, @Param("name") String name);
    void update(Blog blog);
    void delete(int blogId);
    List<String> selectTitles(String name);

    List<Blog> selectAllbyname(String name);

    Blog selectById(@Param("id") int id);

    Blog selectByTitle(String title);
}
