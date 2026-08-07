package com.lm_api.librarymangementapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lm_api.librarymangementapi.dto.UserRequest;
import com.lm_api.librarymangementapi.dto.UserResponse;
import com.lm_api.librarymangementapi.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.jboss.logging.MDC.get;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
class UserControllerTest {

    public static final String NAME="sadaf";
    public static final String EMAIL="sadaf@gmail";
    public static final Long U_ID=7L;
    public  static final String STATUS="Granted";

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper objectMapper=new ObjectMapper();

    @MockitoBean
    private UserService userService;

    @Test
    public  void method_should_return_UserResponse() throws Exception{
        UserRequest userRequest=UserRequest.builder()
                .name(NAME).email(EMAIL).build();

        UserResponse response=UserResponse.builder().
                id(U_ID).name(NAME).email(EMAIL)
                .membershipStatus(STATUS).build();

        when(userService.userCreation(userRequest)).thenReturn(response);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userRequest)))

                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.message")
                        .value("user record created successfully"))
                .andExpect(jsonPath("$.data.id").value(U_ID))
                .andExpect(jsonPath("$.data.name").value(NAME))
                .andExpect(jsonPath("$.data.email").value(EMAIL))
                .andExpect(jsonPath("$.data.membershipStatus").value(STATUS));




}
    @Test
    public void method_should_return_UserID_response() throws Exception {

        UserResponse response = UserResponse.builder()
                .id(U_ID)
                .name(NAME)
                .email(EMAIL)
                .membershipStatus(STATUS)
                .build();

        when(userService.getUserById(U_ID)).thenReturn(response);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/users/" + U_ID))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.message")
                        .value("user record fetched successfully"))
                .andExpect(jsonPath("$.data.id").value(U_ID))
                .andExpect(jsonPath("$.data.name").value(NAME))
                .andExpect(jsonPath("$.data.email").value(EMAIL))
                .andExpect(jsonPath("$.data.membershipStatus").value(STATUS));
    }
}