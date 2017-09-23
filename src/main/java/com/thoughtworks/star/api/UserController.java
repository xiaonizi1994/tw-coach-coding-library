package com.thoughtworks.star.api;

import com.thoughtworks.star.entity.User;
import com.thoughtworks.star.exception.UserNotFoundException;
import com.thoughtworks.star.util.StringUtils;
import com.thoughtworks.star.util.UserCache;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserCache userCache = new UserCache();

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user) {
        user.setId(StringUtils.randomUUID());
        userCache.save(user);
        return user;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Collection<User> listAll() {
        return userCache.findAll();
    }

    @GetMapping(params = "age")
    @ResponseStatus(HttpStatus.OK)
    public Collection<User> listByAge(int age) {
        return userCache.findByAge(age);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User update(@PathVariable String id, @RequestBody User user) {
        if (userCache.findById(id) == null) {
            throw new UserNotFoundException();
        }
        return userCache.update(user);
    }
}
