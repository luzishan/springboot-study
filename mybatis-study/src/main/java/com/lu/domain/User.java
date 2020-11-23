package com.lu.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * user实体类
 *
 * @author lzs
 * @version 1.0
 * @date 2020/11/20 17:11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;

    private String name;

    private int age;

    private String email;

    private Date createTime;

    private Date updateTime;

    private Long version;

    private int delFlag;
}
