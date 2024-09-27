package com.example.users.service.abstraction;

import com.example.users.model.request.UserRequest;
import com.example.users.model.response.UserResponse;
import com.example.users.queue.ChangeCardStatusDto;

public interface UserService {
    void createUser(UserRequest request);

    UserResponse getUser(Long id);

    void sendToQueue(ChangeCardStatusDto changeCardStatusDto);


}
