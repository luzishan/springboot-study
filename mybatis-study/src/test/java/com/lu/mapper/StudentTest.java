package com.lu.mapper;

import com.lu.domain.Course;
import com.lu.domain.Student;
import com.lu.utils.MybatisUtil;
import org.junit.Test;

import java.util.List;

/**
 * StudentTest
 * @author lzs
 * @version 1.0
 * @date 2020/11/24 11:38
 */
public class StudentTest {

    @Test
    public void list(){
        StudentMapper mapper = MybatisUtil.getSqlSession().getMapper(StudentMapper.class);
        List<Student> list = mapper.list();
        for (Student s:list) {
            System.out.println(s);
        }
    }

    @Test
    public void getById(){
        StudentMapper mapper = MybatisUtil.getSqlSession().getMapper(StudentMapper.class);
        Student byId = mapper.getById(1l);
        List<Course> list = byId.getCourseList();
        for(Course c : list){
            System.out.println(c);
        }
        System.out.println(byId);

    }
}
