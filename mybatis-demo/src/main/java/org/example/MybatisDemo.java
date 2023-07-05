package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.pojo.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Xuanchi Guo
 * @project Default (Template) Project
 * @created 7/5/23
 */
public class MybatisDemo {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);


        SqlSession openSession = sqlSessionFactory.openSession();
        List<User> users = openSession.selectList("test.selectAll");

        System.out.println(users);

        openSession.close();
    }
}