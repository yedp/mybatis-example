package com.example.mapper;

import com.example.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

public class UserMapperTest {
    // 指定MyBatis配置文件
    final String RESOURCE = "mybatis-config.xml";
    SqlSessionFactory sessionFactory = null;

    @Before
    public void before() {
        try {

            // 1、指定MyBaties配置文件
            InputStream inputstream = Resources.getResourceAsStream(RESOURCE);
            // 2、创建SqlSessionFactory()
            sessionFactory = new SqlSessionFactoryBuilder().build(inputstream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() {

        // 3、获取SqlSession
        SqlSession session = sessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.selectByPrimaryKey(1L);
        System.out.println(String.format("userId:%s,userName:%s,age:%s", user.getId(), user.getUserName(), user.getAge()));
    }

}
