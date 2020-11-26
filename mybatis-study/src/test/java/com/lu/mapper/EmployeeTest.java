package com.lu.mapper;

import com.lu.domain.Employee;
import com.lu.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * TODO
 *
 * @author lzs
 * @version 1.0
 * @date 2020/11/26 10:50
 */
public class EmployeeTest {

    @Test
    public void getById(){
        EmployeeMapper mapper = MybatisUtil.getSqlSession().getMapper(EmployeeMapper.class);
        Employee byId = mapper.getById(1);
        System.out.println(byId);
    }

    @Test
    public void whereList(){
        EmployeeMapper mapper = MybatisUtil.getSqlSession().getMapper(EmployeeMapper.class);
        Employee employee = new Employee();
        employee.setId(3);
        List<Employee> list = mapper.whereList(employee);
        for(Employee e: list){
            System.out.println(e);
        }

    }

    @Test
    public void ifList(){
        EmployeeMapper mapper = MybatisUtil.getSqlSession().getMapper(EmployeeMapper.class);
        Employee employee = new Employee();
        employee.setId(3);
        employee.setAddress("上海市");
        List<Employee> list = mapper.ifList(employee);
        for(Employee e: list){
            System.out.println(e);
        }

    }

    @Test
    public void trimList(){
        EmployeeMapper mapper = MybatisUtil.getSqlSession().getMapper(EmployeeMapper.class);
        Employee employee = new Employee();
        employee.setId(3);
        employee.setAddress("上海市");
        List<Employee> list = mapper.trimList(employee);
        for(Employee e: list){
            System.out.println(e);
        }

    }

    @Test
    public void chooseWhenOtherwise(){
        EmployeeMapper mapper = MybatisUtil.getSqlSession().getMapper(EmployeeMapper.class);
        Employee employee = new Employee();
        employee.setId(2);
        employee.setAddress("上海市");
        List<Employee> list = mapper.chooseWhenOtherwise(employee);
        for(Employee e: list){
            System.out.println(e);
        }

    }

    @Test
    public void foreachList(){
        EmployeeMapper mapper = MybatisUtil.getSqlSession().getMapper(EmployeeMapper.class);
        List<Employee> list = mapper.foreachList(Arrays.asList(2,3));
        for(Employee e: list){
            System.out.println(e);
        }

    }

    @Test
    public void bindList(){
        EmployeeMapper mapper = MybatisUtil.getSqlSession().getMapper(EmployeeMapper.class);
        List<Employee> list = mapper.bindList("市");
        for(Employee e: list){
            System.out.println(e);
        }

    }

    @Test
    public void updateSql(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = new Employee();
        employee.setId(1);
        employee.setAddress("深圳市");
        int result = mapper.updateSql(employee);
        sqlSession.commit();
        System.out.println(result);
    }
}
