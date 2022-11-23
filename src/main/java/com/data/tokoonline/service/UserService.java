package com.data.tokoonline.service;

import com.data.tokoonline.model.User;

public interface UserService {
    User addUser (User user);

    Object getUserById (Long id);

    Object getAllUser();

    Object editUserById(Long id,String username, String email,Integer age,String address,Integer phoneNumber);

    void deleteUserById(Long Id);
}
