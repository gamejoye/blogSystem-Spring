package com.gamejoye.service;

import com.gamejoye.MybatisMappers.BlogInfoMapper;
import com.gamejoye.MybatisMappers.UsersMapper;
import com.gamejoye.pojo.Blog;
import com.gamejoye.pojo.User;
import com.gamejoye.util.SqlSessionFactoryUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    public List<User> users = new ArrayList<>();
    SqlSessionFactoryUtil sqlSessionFactoryUtil = new SqlSessionFactoryUtil();
    SqlSessionFactory sqlSessionFactory = sqlSessionFactoryUtil.sqlSessionFactoryGet();

    public List<User> selectAll(){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UsersMapper UsersMapper = sqlSession.getMapper(UsersMapper.class);
        users = UsersMapper.selectAll();
        sqlSession.close();
        return users;
    }

    public boolean login(String name ,String password){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UsersMapper UsersMapper = sqlSession.getMapper(UsersMapper.class);
        User u = UsersMapper.login(name,password);
        return  !(u==null);

    }

    public boolean register(String name){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UsersMapper UsersMapper = sqlSession.getMapper(UsersMapper.class);
        User u = new User();
        u = UsersMapper.register(name);
        return  u==null;
    }

    public void add(User user){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UsersMapper usersfoMapper = sqlSession.getMapper(UsersMapper.class);
        usersfoMapper.add(user);
        sqlSession.commit();
        sqlSession.close();
    }
}
