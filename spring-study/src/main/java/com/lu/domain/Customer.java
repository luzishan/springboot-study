package com.lu.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TODO
 *
 * @author lzs
 * @version 1.0
 * @date 2020/12/14 15:07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    private int id;

    private String name;

    private int count;

}
