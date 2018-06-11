package com.zou.primission2.mapper;

import com.zou.primission2.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    User findByUsername(@Param("username") String username);

}




