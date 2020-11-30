package com.lu.mapper;

import com.lu.domain.Employee;
import com.lu.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Calendar;

/**
 * 缓存测试
 *
 * @author lzs
 * @version 1.0
 * @date 2020/11/27 10:43
 */
public class CacheTest {

    @Test
    public void cache1() {
        EmployeeMapper mapper = MybatisUtil.getSqlSession().getMapper(EmployeeMapper.class);
        Employee byId = mapper.getById(1);
        System.out.println(byId);
        Employee byId1 = mapper.getById(1);
        System.out.println(byId1);
        mapper.deleteById(1);
        Employee byId2 = mapper.getById(2);
        System.out.println(byId2);
    }

    @Test
    public void cache2() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee byId = mapper.getById(1);
        System.out.println(byId);
        sqlSession.close();
        SqlSession sqlSession2 = MybatisUtil.getSqlSession();
        EmployeeMapper mapper2 = sqlSession2.getMapper(EmployeeMapper.class);
        Employee byId1 = mapper2.getById(1);
        System.out.println(byId1);
    }

    @Test
    public void ehcacheTest() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee byId = mapper.getById(1);
        System.out.println(byId);
        sqlSession.close();
        EmployeeMapper mapper1 = MybatisUtil.getSqlSession().getMapper(EmployeeMapper.class);
        Employee byId1 = mapper1.getById(1);
        System.out.println(byId1);

    }
}
