package com.gamejoye.service;

import com.gamejoye.MybatisMappers.BlogInfoMapper;
import com.gamejoye.pojo.Blog;
import com.gamejoye.pojo.User;
import com.gamejoye.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;
import java.util.List;

public class Service {

    public List<Blog> blogs = new ArrayList<>();
    SqlSessionFactoryUtil sqlSessionFactoryUtil = new SqlSessionFactoryUtil();
    SqlSessionFactory sqlSessionFactory = sqlSessionFactoryUtil.sqlSessionFactoryGet();
    SqlSession sqlSession = sqlSessionFactory.openSession();
    BlogInfoMapper blogInfoMapper = sqlSession.getMapper(BlogInfoMapper.class);


    public List<Blog> selectAll(){
        blogs = blogInfoMapper.selectAll();
        sqlSession.close();
        return blogs;
    }

    public List<String> selectTitles(String name) {
        List<String> titles = new ArrayList<>();
        titles = blogInfoMapper.selectTitles(name);
        sqlSession.close();
        return titles;
    }

    public List<Blog> selectAllbyName(String name){
        blogs = blogInfoMapper.selectAllbyname(name);
        sqlSession.close();
        return blogs;
    }

    public void add(Blog blog){
        blogInfoMapper.add(blog);
        sqlSession.commit();
        sqlSession.close();
    }

    public Blog selectByArticlename(String article_name){
        Blog blog = null;
        blog = blogInfoMapper.selectByArticlename(article_name);
        return blog;
    }

    public void update(Blog blog){
        blogInfoMapper.update(blog);
        sqlSession.commit();
        sqlSession.close();
    }

    public void delete(int id){
        blogInfoMapper.delete(id);
        sqlSession.commit();
        sqlSession.close();
    }
}
