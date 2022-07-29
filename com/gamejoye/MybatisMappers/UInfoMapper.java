package com.gamejoye.MybatisMappers;

import com.gamejoye.pojo.UInfo;
import org.apache.ibatis.annotations.Param;

public interface UInfoMapper {
    void setAboutMe(@Param("aboutMe") String aboutMe, @Param("name") String name);
    UInfo getInfo(@Param("name") String name);
    void setSex(@Param("sex") String sex,@Param("name") String name);
    void setAddress(@Param("address") String address,@Param("name") String name);
    void setBirthday(@Param("birthday") String birthday,@Param("name") String name);
}
