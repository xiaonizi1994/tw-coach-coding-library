package com.thoughtworks.star.api;

import com.thoughtworks.star.entity.User;
import com.thoughtworks.star.util.StringUtils;
import com.thoughtworks.star.util.UserCache;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user) {
        user.setId(StringUtils.randomUUID());
        UserCache.save(user);
        return user;
    }
}
