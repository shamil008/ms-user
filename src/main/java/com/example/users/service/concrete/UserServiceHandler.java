package com.example.users.service.concrete;

import com.example.users.dao.repository.UserRepository;
import com.example.users.exception.NotFoundException;
import com.example.users.mapper.UserMapper;
import com.example.users.model.enums.ExceptionConstants;
import com.example.users.model.request.UserRequest;
import com.example.users.model.response.UserResponse;
import com.example.users.queue.ChangeCardStatusDto;
import com.example.users.queue.QueueSender;
import com.example.users.service.abstraction.UserService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.users.mapper.UserMapper.USER_MAPPER;
import static com.example.users.model.enums.ExceptionConstants.USER_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class UserServiceHandler implements UserService {
    private final UserRepository userRepository;
    private final QueueSender<ChangeCardStatusDto> queueSender;
    @Override
    public void createUser(UserRequest request) {
        userRepository.save(USER_MAPPER.buildUserEntity(request));
    }

    @Override
    public UserResponse getUser(Long id) {
        var user = userRepository.findById(id).orElseThrow(()-> new NotFoundException(USER_NOT_FOUND.getCode(), USER_NOT_FOUND.getMessage()));
        return USER_MAPPER.buildUserResponse(user);
    }

    @Override
    @PostConstruct
    public void sendToQueue(ChangeCardStatusDto changeCardStatusDto) {
        queueSender.sendMessageToQ("USER_Q",new ChangeCardStatusDto(1L));
    }
}
