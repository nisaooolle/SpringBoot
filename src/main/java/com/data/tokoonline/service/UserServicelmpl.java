package com.data.tokoonline.service;

import com.data.tokoonline.exception.EmailException;
import com.data.tokoonline.exception.InternalErorException;
import com.data.tokoonline.exception.NotFoundException;
import com.data.tokoonline.model.User;
import com.data.tokoonline.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServicelmpl implements UserService{
    @Autowired
    UserRepository userRepository;

    @Override
    public User addUser(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new EmailException("Email already exist");
        }
        return userRepository.save(user);
    }

    @Override
    public Object getUserById(Long id) {
        var user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("Id tidak ditemukan"));
        try {
            return userRepository.findById(id);
        }catch (Exception e) {
            throw new InternalErorException("Kesalahan memunculkan data");
        }
    }

    @Override
    public Object getAllUser() {
        try {
            return userRepository.findAll();
        }catch (Exception e) {
            return "Kesalahan memunculkan data";
        }
    }

    @Override
    public Object editUserById(Long id, String username, String email, Integer age, String address, Integer phoneNumber) {
        User user = userRepository.findById(id).get();
        user.setUsername(username);
        user.setEmail(email);
        user.setAge(age);
        user.setAddress(address);
        user.setPhoneNumber(phoneNumber);
        return userRepository.save(user);
    }
    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
