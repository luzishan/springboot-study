package com.lu.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * TODO
 *
 * @author lzs
 * @version 1.0
 * @date 2020/11/26 10:46
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable{

    private Integer id;

    private String name;

    private Integer age;

    private String address;

    private String phone;
}
