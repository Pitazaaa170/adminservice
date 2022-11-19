package com.pitaza.adminservice.mapper.impl;

import com.pitaza.adminservice.dao.entity.UserEntity;
import com.pitaza.adminservice.dto.UserDto;
import com.pitaza.adminservice.mapper.BaseMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements BaseMapper<UserEntity, UserDto> {

    @Override
    public UserDto mapFrom(UserEntity object) {
        return new UserDto(object.getId(),
                object.getName(),
                object.getSurname(),
                object.getRole(),
                object.isRegistered(),
                object.isBlocked());
    }
}
