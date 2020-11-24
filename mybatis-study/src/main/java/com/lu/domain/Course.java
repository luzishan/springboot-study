package com.lu.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author lzs
 * @version 1.0
 * @date 2020/11/24 19:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    private int id;

    private String courseName;

    private int sId;
}
