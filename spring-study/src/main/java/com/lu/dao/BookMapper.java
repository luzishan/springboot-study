package com.lu.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper {

    public int getBookPriceByBookId(int bookId);
}
