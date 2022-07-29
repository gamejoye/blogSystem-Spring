package com.gamejoye.service;

import com.gamejoye.MybatisMappers.BlogInfoMapper;
import com.gamejoye.MybatisMappers.UInfoMapper;
import com.gamejoye.pojo.UInfo;
import com.gamejoye.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UInfoService {
    SqlSessionFactoryUtil sqlSessionFactoryUtil = new SqlSessionFactoryUtil();
    SqlSessionFactory sqlSessionFactory = sqlSessionFactoryUtil.sqlSessionFactoryGet();
    SqlSession sqlSession = sqlSessionFactory.openSession();
    UInfoMapper uInfoMapper = sqlSession.getMapper(UInfoMapper.class);

    public UInfo getInfo(String name) {
        UInfo info = uInfoMapper.getInfo(name);
        sqlSession.close();
        return info;
    }

    public void setAboutMe(String aboueMe,String name) {
        uInfoMapper.setAboutMe(aboueMe,name);
        sqlSession.commit();
        sqlSession.close();
    }

    public void setSex(String sex, String username) {
        uInfoMapper.setSex(sex,username);
        sqlSession.commit();
        sqlSession.close();
    }

    public void setAddress(String address, String username) {
        uInfoMapper.setAddress(address,username);
        sqlSession.commit();
        sqlSession.close();
    }

    public void setBirthday(String birthday, String username) {
        uInfoMapper.setBirthday(birthday,username);
        sqlSession.commit();
        sqlSession.close();
    }
}
