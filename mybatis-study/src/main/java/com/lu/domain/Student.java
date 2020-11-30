package com.lu.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author lzs
 * @version 1.0
 * @date 2020/11/24 10:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {

    private Long id;

    private String sName;

    private int age;

    private StudentClass studentClass;

    private List<Course> courseList;
}
