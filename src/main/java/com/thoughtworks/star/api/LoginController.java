package com.thoughtworks.star.api;

import com.thoughtworks.star.dto.LoginRequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @PostMapping("/api/login")
    public String login(@RequestBody LoginRequestBody requestBody) {
        if ("admin".equals(requestBody.getUsername()) && "123".equals(requestBody.getPassword())) {
            return String.join(" ", requestBody.getUsername(), "login successfully.");
        }

        throw new IllegalArgumentException("Invalid username or password");
    }
}
