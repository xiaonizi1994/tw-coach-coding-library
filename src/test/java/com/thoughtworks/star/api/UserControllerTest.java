package com.thoughtworks.star.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.star.dto.LoginRequestBody;
import com.thoughtworks.star.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class UserControllerTest extends BaseControllerTest {

    /**
     * 1. 创建一个用户
     */
    @Test
    void should_create_user() throws Exception {
        User user = User.builder().username("future_star").password("123456").age(22).build();
        mockMvc.perform(post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(user)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").isNotEmpty())
                .andExpect(jsonPath("$.username").value("future_star"))
                .andExpect(jsonPath("$.password").value("123456"))
                .andExpect(jsonPath("$.age").value(22));
    }

}