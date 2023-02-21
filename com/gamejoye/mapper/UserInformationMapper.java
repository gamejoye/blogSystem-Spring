package com.gamejoye.mapper;

import com.gamejoye.pojo.UserInformation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface UserInformationMapper {
    UserInformation getInfo(@Param("name") String name);
    String getAboutMe(String name);
    void add(@Param("name") String name);
    void update(UserInformation userInformation);
}
