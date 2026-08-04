package com.lm_api.librarymangementapi.service;

import com.lm_api.librarymangementapi.dto.UserRequest;
import com.lm_api.librarymangementapi.dto.UserResponse;
import com.lm_api.librarymangementapi.entities.UserEntity;
import com.lm_api.librarymangementapi.mapper.UserMapper;
import com.lm_api.librarymangementapi.repository.LoanRepository;
import com.lm_api.librarymangementapi.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    public static final String NAME="sadaf";
    public static final String EMAIL="sadaf@gmail";
    public static final Long U_ID=7L;
    public  static final String STATUS="Granted";
    @Mock
    private  UserMapper userMapper;
    @Mock
    private  UserRepository userRepository;
    @InjectMocks
    private UserService  userService;

    @Test
    public void method_should_return_userResponse(){
        UserRequest userRequest=UserRequest.builder()
                .name(NAME).email(EMAIL).build();

        UserEntity user=UserEntity.builder().
                id(U_ID).name(NAME).email(EMAIL)
                .membershipStatus(STATUS).build();

        UserResponse response=UserResponse.builder().
                id(U_ID).name(NAME).email(EMAIL)
                .membershipStatus(STATUS).build();

        when(userMapper.transformToUserEntity(userRequest)).thenReturn(user);
        when(userRepository.save(user)).thenReturn(user);
        when(userMapper.transformToUserResponse(user)).thenReturn(response);

        UserResponse userResponse=userService.userCreation(userRequest);
        assertAll(()-> assertEquals(U_ID,userResponse.id()),
                ()-> assertEquals(NAME,userResponse.name()),
                ()-> assertEquals(EMAIL,userResponse.email()),
                ()-> assertEquals(STATUS,userResponse.membershipStatus()));
        verify(userMapper).transformToUserEntity(userRequest);
        verify(userRepository).save(user);
        verify(userMapper).transformToUserResponse(user);


    }

}