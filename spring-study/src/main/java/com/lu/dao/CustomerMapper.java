package com.lu.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * TODO
 *
 * @author lzs
 * @version 1.0
 * @date 2020/12/14 15:02
 */
@Mapper
public interface CustomerMapper {

    public int updateCustomerCount(@Param("id") int id,@Param("count") int count);
}
