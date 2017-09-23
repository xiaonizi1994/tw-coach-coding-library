package com.thoughtworks.star.util;

import com.thoughtworks.star.entity.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserCache {
    private static final Map<String, User> NAME_USERS = new HashMap<>();
    private static final Map<String, User> ID_USERS = new HashMap<>();

    static {
        User user = User.builder().id(StringUtils.randomUUID()).username("future_star").password("123455").age(22).build();
        NAME_USERS.put(user.getUsername(), user);
        ID_USERS.put(user.getId(), user);
    }

    public User findById(String id) {
        return ID_USERS.get(id);
    }

    public User findByName(String username) {
        return NAME_USERS.get(username);
    }

    public User save(User user) {
        NAME_USERS.put(user.getUsername(), user);
        ID_USERS.put(user.getId(), user);
        return user;
    }

    public void clear(){
        NAME_USERS.clear();
        ID_USERS.clear();
    }

    public Collection<User> findAll() {
        return ID_USERS.values();
    }

    public User update(User user) {
        ID_USERS.put(user.getId(),user);
        NAME_USERS.put(user.getUsername(),user);
        return user;
    }
}
