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

    final String RESOURCE = "mybatis-config.xml";
    SqlSessionFactory sessionFactory = null;

    @Before
    public void before() {
        try {

            // 1
            InputStream inputstream = Resources.getResourceAsStream(RESOURCE);
            // 2
            sessionFactory = new SqlSessionFactoryBuilder().build(inputstream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() {
        // 3
        SqlSession session = sessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.selectByPrimaryKey(1L);
        System.out.println(String.format("userId:%s,userName:%s,nickname:%s", user.getId(), user.getUsername(), user.getNickname()));
    }

}
