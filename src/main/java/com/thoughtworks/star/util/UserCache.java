package com.thoughtworks.star.util;

import com.thoughtworks.star.entity.User;

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

    public static User findById(String id) {
        return ID_USERS.get(id);
    }

    public static User findByName(String username) {
        return NAME_USERS.get(username);
    }

    public static void save(User user) {
        NAME_USERS.put(user.getUsername(), user);
        ID_USERS.put(user.getId(), user);
    }
}
