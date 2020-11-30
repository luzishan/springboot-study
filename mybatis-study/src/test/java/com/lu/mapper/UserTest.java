package com.lu.mapper;

import com.lu.domain.User;
import com.lu.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lzs
 * @version 1.0
 * @date 2020/11/20 17:23
 */

public class UserTest {

   /* private static SqlSession sqlSession;

    {
        String resource = "mybatis-config.xml";
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            sqlSession = build.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    @Test
    public void test() throws IOException {
        SqlSession sqlSession1 = MybatisUtil.getSqlSession();
        System.out.println("======="+sqlSession1);
        UserMapper mapper = sqlSession1.getMapper(UserMapper.class);
        for (User user:mapper.getUserList()) {
            System.out.println(user);
        }
        SqlSession sqlSession2 = MybatisUtil.getSqlSession();
        System.out.println("======="+sqlSession2);
    }

    @Test
    public void getById(){
        UserMapper mapper = MybatisUtil.getSqlSession().getMapper(UserMapper.class);
        User user = mapper.getById(1L);
        System.out.println(user);

    }

    @Test
    public void getByIdAndName(){
        UserMapper mapper = MybatisUtil.getSqlSession().getMapper(UserMapper.class);
        User jack = mapper.getByIdAndName(2L, "Jack");
        System.out.println(jack);
    }

    @Test
    public void getByIdAndName2(){
        UserMapper mapper = MybatisUtil.getSqlSession().getMapper(UserMapper.class);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("id",2L);
        map.put("name","Jack");
        User byIdAndName2 = mapper.getByIdAndName2(map);
        System.out.println(byIdAndName2);
    }

    @Test
    public void getUserList2(){
        UserMapper mapper = MybatisUtil.getSqlSession().getMapper(UserMapper.class);
        List<User> userList2 = mapper.getUserList2();
        for (User user:userList2) {
            System.out.println(user);
        }
    }

    @Test
    public void ehcacheTest(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User byId = mapper.getById(1L);
        System.out.println(byId);
        sqlSession.close();
        UserMapper mapper1 = MybatisUtil.getSqlSession().getMapper(UserMapper.class);
        User byId1 = mapper1.getById(1l);
        System.out.println(byId1);
    }
}
