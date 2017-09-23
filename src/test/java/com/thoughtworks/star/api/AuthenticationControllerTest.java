package com.thoughtworks.star.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.star.dto.LoginRequestBody;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class AuthenticationControllerTest extends BaseControllerTest {

    /**
     * 2.1 完成成功登陆API
     */
    @Test
    void should_login_successfully() throws Exception {
        LoginRequestBody loginRequestBody = LoginRequestBody.builder()
                .username("future_star")
                .password("123456")
                .build();
        mockMvc.perform(post("/api/authentication")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(loginRequestBody)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").value("future_star login successfully."));
    }

    /**
     * 2.2 完成登陆失败API
     */
    @Test
    void should_login_failed_when_login_with_bad_credential() throws Exception {
        LoginRequestBody loginRequestBody = LoginRequestBody.builder()
                .username("future_star")
                .password("wrong_password")
                .build();
        mockMvc.perform(post("/api/authentication")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(loginRequestBody)))
                .andExpect(status().isUnauthorized())
                .andDo(print())
                .andExpect(jsonPath("$").value("Invalid password."));
    }

}