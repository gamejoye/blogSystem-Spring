package com.gamejoye.mapper;

import com.gamejoye.pojo.UserPrivacy;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface UserPrivacyMapper {
    UserPrivacy selectOne(@Param("name")String name);
    void add(UserPrivacy userPrivacy);
    UserPrivacy login(@Param("name")String name , @Param ("password")String password);
    void update(UserPrivacy userPrivacy);
    void delete(String name);
    UserPrivacy register(@Param("name") String name);
}
