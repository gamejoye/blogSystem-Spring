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
    SqlSession sqlSession = sqlSessionFactory.openSession();
    UsersMapper UsersMapper = sqlSession.getMapper(UsersMapper.class);

    public User selectOne(String name){

        User user = UsersMapper.selectOne(name);
        sqlSession.close();
        return user;
    }

    public boolean login(String name ,String password){

        User u = UsersMapper.login(name,password);
        return  !(u==null);

    }

    public boolean register(String name){
        User u = new User();
        u = UsersMapper.register(name);
        return  !(u==null);
    }

    public void add(User user){

        UsersMapper.add(user);
        sqlSession.commit();
        sqlSession.close();
    }

}
