package com.gamejoye.MybatisMappers;

import com.gamejoye.pojo.Blog;
import com.gamejoye.pojo.User;

import java.util.List;

public interface BlogInfoMapper {

    List<Blog> selectAll();
    void add(Blog blog);
    Blog selectByArticlename(String title);
    void update(Blog blog);
    void delete(int id);
    List<String> selectTitles(String name);

    List<Blog> selectAllbyname(String name);
}
