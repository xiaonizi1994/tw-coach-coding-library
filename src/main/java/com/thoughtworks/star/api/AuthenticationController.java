package com.thoughtworks.star.api;

import com.thoughtworks.star.dto.LoginRequestBody;
import com.thoughtworks.star.exception.InvalidCredentialException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @PostMapping("/api/authentication")
    @ResponseStatus(HttpStatus.CREATED)
    public String login(@RequestBody LoginRequestBody requestBody) {
        if ("future_star".equals(requestBody.getUsername()) && "123456".equals(requestBody.getPassword())) {
            return String.join(" ", requestBody.getUsername(), "login successfully.");
        }
        throw new InvalidCredentialException("Invalid username or password.");
    }

}
