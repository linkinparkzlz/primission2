package com.zou.primission2.service;

import com.zou.primission2.model.User;

public interface UserService {

    User findByUsername(String username);

}
