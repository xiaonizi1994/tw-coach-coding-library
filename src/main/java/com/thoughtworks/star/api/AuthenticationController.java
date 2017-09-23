package com.thoughtworks.star.api;

import com.thoughtworks.star.dto.LoginRequestBody;
import com.thoughtworks.star.entity.User;
import com.thoughtworks.star.exception.InvalidCredentialException;
import com.thoughtworks.star.exception.UserNotFoundException;
import com.thoughtworks.star.util.UserCache;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private UserCache userCache = new UserCache();

    @PostMapping("/api/authentication")
    @ResponseStatus(HttpStatus.CREATED)
    public String login(@RequestBody LoginRequestBody requestBody) {
        User user = userCache.findByName(requestBody.getUsername());
        if (user == null) {
            throw new InvalidCredentialException("Invalid username.");
        }
        if (user.getPassword().equals(requestBody.getPassword())) {
            return String.join(" ", requestBody.getUsername(), "login successfully.");
        }
        throw new InvalidCredentialException("Invalid password.");
    }

}
