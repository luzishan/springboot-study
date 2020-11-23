package com.lu.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author lzs
 * @version 1.0
 * @date 2020/11/21 9:44
 */
public class MybatisUtil {

    private static SqlSessionFactory sqlSessionFactory;

    static{
        String url = "mybatis-config.xml";
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream(url);
            //获取sqlsessionFactoory
             sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }


}
