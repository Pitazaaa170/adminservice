package com.pitaza.adminservice.dto;

import lombok.Value;

@Value
public class UserDto {
    long id;
    String name;
    String surname;
    String role;
    boolean isRegistered;
    boolean isBlocked;
}
