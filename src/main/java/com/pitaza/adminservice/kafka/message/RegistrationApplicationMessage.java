package com.pitaza.adminservice.kafka.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegistrationApplicationMessage {
    private long id;
    private String name;
    private String surname;
    private String role;
    private boolean status;
}
