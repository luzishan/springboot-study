package com.lu.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TODO
 *
 * @author lzs
 * @version 1.0
 * @date 2020/12/14 15:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private int id;

    private String bookName;

    private int bookPrice;
}
