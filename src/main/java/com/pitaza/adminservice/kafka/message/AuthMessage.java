package com.pitaza.adminservice.kafka.message;

import com.pitaza.adminservice.dto.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthMessage{

        private int id;
        private String name;
        private String surname;
        private Role role;
        private boolean status;

}