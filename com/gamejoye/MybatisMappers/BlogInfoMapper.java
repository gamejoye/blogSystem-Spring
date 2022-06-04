package com.gamejoye.MybatisMappers;

import com.gamejoye.pojo.Blog;
import com.gamejoye.pojo.User;

import java.util.List;

public interface BlogInfoMapper {

    List<Blog> selectAll();
    void add(Blog blog);
    Blog selectByid(Integer id);
    void update(Blog blog);
    void delete(int id);

    List<Blog> selectAllbyname(String name);
}
