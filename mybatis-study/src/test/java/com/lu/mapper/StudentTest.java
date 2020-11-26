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

    @Test
    public void getById3(){
        StudentMapper mapper = MybatisUtil.getSqlSession().getMapper(StudentMapper.class);
        Student byId = mapper.getById3(1);
        /*List<Course> list = byId.getCourseList();
        for(Course c : list){
            System.out.println(c);
        }*/
        System.out.println(byId.getSName());
        System.out.println(byId.getCourseList().get(0).getCourseName());

    }

    @Test
    public void getByIdStep(){
        StudentMapper mapper = MybatisUtil.getSqlSession().getMapper(StudentMapper.class);
        Student byIdStep = mapper.getByIdStep(1);
        System.out.println(byIdStep.getSName());
        System.out.println(byIdStep.getStudentClass().getClassName());
    }
}
