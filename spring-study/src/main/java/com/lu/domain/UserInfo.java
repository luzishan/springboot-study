package com.lu.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author lzs
 * @version 1.0
 * @date 2020/11/30 10:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {

    private int id;

    private String name;

    private String address;

    private int age;

    private BookBean book;


}
