package com.example.users.mapper;

import com.example.users.dao.entity.UserEntity;
import com.example.users.model.enums.UserStatus;
import com.example.users.model.request.UserRequest;
import com.example.users.model.response.UserResponse;

import static com.example.users.model.enums.UserStatus.ACTIVE;


public enum UserMapper {
    USER_MAPPER;
    public UserEntity buildUserEntity(UserRequest request){
        return UserEntity.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .status(ACTIVE)
                .build();
    }

    public UserResponse buildUserResponse (UserEntity userEntity){
        return UserResponse.builder()
                .id(userEntity.getId())
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .status(userEntity.getStatus())
                .build();
    }
}
