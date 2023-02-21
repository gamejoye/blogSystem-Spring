package com.gamejoye.service;

import com.gamejoye.mapper.BlogMapper;
import com.gamejoye.pojo.Blog;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "BlogService")
public class BlogService {

    @Autowired
    SqlSessionTemplate sqlSession;

    @Autowired
    BlogMapper blogMapper;

    public List<Blog> selectAllbyName(String name) {
        List<Blog> blogs = blogMapper.selectAllbyname(name);
        return blogs;
    }

    public void add(Blog blog) {
        blogMapper.add(blog);
    }

    public Blog selectByArticlename(String title, String name) {
        Blog blog = blogMapper.selectByArticlename(title, name);
        return blog;
    }

    public Blog selectById(int id) {
        Blog blog = blogMapper.selectById(id);
        return blog;
    }

    public void update(Blog blog) {
        blogMapper.update(blog);
    }

    public void delete(int blogId) {
        blogMapper.delete(blogId);
    }
}
