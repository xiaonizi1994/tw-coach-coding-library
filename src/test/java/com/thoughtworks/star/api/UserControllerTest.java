package com.thoughtworks.star.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.star.entity.User;
import com.thoughtworks.star.util.StringUtils;
import com.thoughtworks.star.util.UserCache;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class UserControllerTest extends BaseControllerTest {

    /**
     * 创建一个用户
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

    /**
     * 查询用户列表
     */
    @Test
    void should_list_users() throws Exception {
        User user = User.builder().id(StringUtils.randomUUID()).username("admin").password("123").age(25).build();
        UserCache userCache = new UserCache();
        userCache.clear();
        userCache.save(user);
        mockMvc.perform(get("/api/users")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id").isNotEmpty())
                .andExpect(jsonPath("$[0].username").value("admin"))
                .andExpect(jsonPath("$[0].password").value("123"))
                .andExpect(jsonPath("$[0].age").value(25));
    }

    /**
     * 更新用户年龄
     */
    @Test
    void should_update_user() throws Exception {
        User user = User.builder().id(StringUtils.randomUUID()).username("admin").password("123").age(25).build();
        UserCache userCache = new UserCache();
        userCache.clear();
        userCache.save(user);

        User updatedUser = User.builder().id(user.getId()).username("admin1").password("321").age(29).build();
        mockMvc.perform(put("/api/users/" + user.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(updatedUser)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").isNotEmpty())
                .andExpect(jsonPath("$.username").value("admin1"))
                .andExpect(jsonPath("$.password").value("321"))
                .andExpect(jsonPath("$.age").value(29));
    }

}