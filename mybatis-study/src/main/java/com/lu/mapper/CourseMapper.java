package com.lu.mapper;

import com.lu.domain.Course;

import java.util.List;

/**
 * TODO
 *
 * @author lzs
 * @version 1.0
 * @date 2020/11/24 20:41
 */
public interface CourseMapper {

    public List<Course> getByStudentId(int id);
}
