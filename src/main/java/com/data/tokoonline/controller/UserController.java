package com.data.tokoonline.controller;

import com.data.tokoonline.model.User;
import com.data.tokoonline.response.ResponseHelper;
import com.data.tokoonline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public Object getAllUser() {
        return ResponseHelper.ok(userService.getAllUser());
    }

    @GetMapping("/{id}")
    public Object getUserById(@PathVariable("id")Long id) {
        return ResponseHelper.ok(userService.getUserById(id)) ;
    }

    @PostMapping
    public Object addUser(@RequestBody User user) {
        return ResponseHelper.ok(userService.addUser(user));
    }

    @PutMapping("/{id}")
    public Object editUserById(@PathVariable("id") Long id, @RequestBody User user) {
        return ResponseHelper.ok(userService.editUserById(id,user.getUsername(),user.getEmail(),user.getAge(),user.getAddress(),user.getPhoneNumber()));
    }

    @DeleteMapping("/{id}")
    public void deleteUSerById(@PathVariable("id") Long id) { userService.deleteUserById(id);}
}
