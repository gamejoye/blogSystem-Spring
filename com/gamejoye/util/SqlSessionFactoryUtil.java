package com.gamejoye.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class SqlSessionFactoryUtil {
    static SqlSessionFactory sqlSessionFactory;

    static {
        try{
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public SqlSessionFactory sqlSessionFactoryGet(){
        return sqlSessionFactory;
    }
}
