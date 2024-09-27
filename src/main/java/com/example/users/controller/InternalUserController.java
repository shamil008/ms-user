package com.example.users.controller;

import com.example.users.model.response.UserResponse;
import com.example.users.service.abstraction.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("internal/v1/users")
public class InternalUserController {
    private final UserService userService;

    @GetMapping("{id}")
    public UserResponse getUser(@PathVariable Long id){
        return  userService.getUser(id);
    }
}
