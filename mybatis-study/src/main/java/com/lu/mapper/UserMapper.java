package com.lu.mapper;

import com.lu.domain.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    public List<User> getUserList();

    public List<User> getUserList2();

    public User getById(Long id);

    public User getByIdAndName(@Param("id") Long id, @Param("name") String name);

    @MapKey("id")
    public User getByIdAndName2(Map<String,Object> map);
}
