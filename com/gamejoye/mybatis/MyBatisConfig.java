package com.gamejoye.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;

@Configuration
public class MyBatisConfig {

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

    @Bean
    public SqlSessionTemplate sqlSession() throws Exception {
        System.out.println("注入");
        return new SqlSessionTemplate(sqlSessionFactoryGet());
    }
}