package com.example.dataroutetest.mapper;

import com.example.dataroutetest.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Select("SELECT * FROM users")
    List<User> findAll();
}
