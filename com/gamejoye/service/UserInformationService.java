package com.gamejoye.service;

import com.gamejoye.mapper.UserInformationMapper;
import com.gamejoye.pojo.UserInformation;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "UserInformationService")
public class UserInformationService {
    @Autowired
    SqlSessionTemplate sqlSession;

    @Autowired
    UserInformationMapper userInformationMapper;
    public UserInformation getInfo(String name) {

        UserInformation info = userInformationMapper.getInfo(name);
        return info;
    }

    public void updateUserInfo(UserInformation userInformation) {
        userInformationMapper.update(userInformation);
    }

    public void updateAvatarUrl(String name, String avatarUrl) {
        userInformationMapper.updateAvatar(name, avatarUrl);
    }
}
