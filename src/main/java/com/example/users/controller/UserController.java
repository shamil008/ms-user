package com.example.users.controller;

import com.example.users.model.request.UserRequest;
import com.example.users.model.response.UserResponse;
import com.example.users.service.abstraction.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    @ResponseStatus(CREATED)
    public void createUser(@RequestBody UserRequest request){
        userService.createUser(request);
    }

    @GetMapping("{id}")
    public UserResponse getUser(@PathVariable Long id){
        return  userService.getUser(id);
    }
}
