package com.pitaza.adminservice.dao.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    private long id;
    private String name;
    private String surname;
    private String role;
    private boolean isRegistered;
    private boolean isBlocked;
}
