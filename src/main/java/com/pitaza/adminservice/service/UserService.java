package com.pitaza.adminservice.service;

import com.pitaza.adminservice.dto.ProcessRegistrationDto;
import com.pitaza.adminservice.dto.UserDto;

import java.util.List;

public interface UserService {

    void saveUser(UserDto userDto);

    List<UserDto> getUnregisteredUsers();

    void processRegistration(ProcessRegistrationDto processRegistrationDto);

    UserDto getUserById(long id);

    void blockUserById(long id);

    void unBlockUserById(long id);
}
