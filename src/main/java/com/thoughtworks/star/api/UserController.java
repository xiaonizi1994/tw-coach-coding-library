package com.thoughtworks.star.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping(value = "/{user_id}/contacts/{contact_id}")
    public String findContactsById(@PathVariable("user_id") String userId, @PathVariable("contact_id") String contactId) {
        return String.join(":", userId, contactId);
    }

    @GetMapping(value = "/{id}")
    public String findById(@PathVariable String id) {
        return String.join(":", "user", id);
    }

    @GetMapping(params = "age")
    public String listForceParam(@RequestParam int age) {
        return "Force user with age = " + age;
    }

    @GetMapping
    public String listUsers(@RequestParam String name) {
        return "user with name = " + name;
    }
}
