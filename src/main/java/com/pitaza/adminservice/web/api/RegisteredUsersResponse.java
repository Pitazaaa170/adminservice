package com.pitaza.adminservice.web.api;

import com.pitaza.adminservice.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisteredUsersResponse {
    private List<UserDto> registeredUsers;
}
