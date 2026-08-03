package com.lm_api.librarymangementapi.mapper;

import com.lm_api.librarymangementapi.dto.UserRequest;
import com.lm_api.librarymangementapi.dto.UserResponse;
import com.lm_api.librarymangementapi.entities.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserResponse transformToUserResponse(UserEntity userEntity){
        return new UserResponse(
                userEntity.getId(),
                userEntity.getName(),
                userEntity.getEmail(),
                userEntity.getMembershipStatus()
        );

    }

    public UserEntity transformToUserEntity(UserRequest userRequest){
        return UserEntity.builder()
                .name(userRequest.name())
                .email(userRequest.email())
                .membershipStatus("Granted").build();
    }


    public UserEntity updateUser(UserEntity user,UserRequest userRequest){
        user.setName(userRequest.name());
        user.setEmail(userRequest.email());
        return user;
    }
}
