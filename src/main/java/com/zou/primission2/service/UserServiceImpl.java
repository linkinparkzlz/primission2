package com.zou.primission2.service;

import com.zou.primission2.mapper.UserMapper;
import com.zou.primission2.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;


    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }
}
