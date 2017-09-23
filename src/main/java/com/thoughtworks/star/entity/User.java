package com.thoughtworks.star.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Builder
@ToString
public class User {
    private String id;
    private String username;
    private String password;
    private int age;
}
