package com.gamejoye.MybatisMappers;

import com.gamejoye.pojo.Blog;
import com.gamejoye.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UsersMapper {
    List<User> selectByLevel(@Param("level")int level);
    User selectOne(@Param("name")String name);
    void add(User user);
    User login(@Param("name")String name , @Param ("password")String password);
    void update(User user);
    void delete(String name);

    User register(String name);

}
