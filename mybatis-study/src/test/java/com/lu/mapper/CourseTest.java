package com.lu.mapper;

import com.lu.domain.Course;
import com.lu.utils.MybatisUtil;
import org.junit.Test;

import java.util.List;

/**
 * TODO
 *
 * @author lzs
 * @version 1.0
 * @date 2020/11/25 0:10
 */
public class CourseTest {

    @Test
    public void getByStudentId(){
        CourseMapper mapper = MybatisUtil.getSqlSession().getMapper(CourseMapper.class);
        List<Course> byStudentId = mapper.getByStudentId(1);
        for(Course c : byStudentId){
            System.out.println(c);
        }
    }
}
