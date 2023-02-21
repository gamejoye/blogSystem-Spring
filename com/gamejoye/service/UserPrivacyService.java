package com.gamejoye.service;

import com.gamejoye.mapper.UserPrivacyMapper;
import com.gamejoye.pojo.UserPrivacy;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "UserPrivacyService")
public class UserPrivacyService {

    @Autowired
    SqlSessionTemplate sqlSession;

    @Autowired
    UserPrivacyMapper userPrivacyMapper;
    public UserPrivacy selectOne(String name){
        UserPrivacy userPrivacy = userPrivacyMapper.selectOne(name);
        return userPrivacy;
    }

    public boolean login(String name ,String password){
        UserPrivacy u = userPrivacyMapper.login(name,password);
        return  !(u==null);
    }

    public boolean register(String name){
        UserPrivacy u = userPrivacyMapper.register(name);
        return  !(u==null);
    }

    public void add(UserPrivacy userPrivacy){
        userPrivacyMapper.add(userPrivacy);
    }

}
