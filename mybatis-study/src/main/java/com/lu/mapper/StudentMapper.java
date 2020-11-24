package com.lu.mapper;

import com.lu.domain.Student;

import java.util.List;

/**
 * StudentMapper
 * @author lzs
 * @version 1.0
 * @date 2020/11/24 11:34
 */
public interface StudentMapper {

    public List<Student> list();

    public Student getById(Long id);
}
