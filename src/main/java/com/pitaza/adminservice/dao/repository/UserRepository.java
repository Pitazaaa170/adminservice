package com.pitaza.adminservice.dao.repository;

import com.pitaza.adminservice.dao.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    int saveUser(UserEntity userEntity);

    List<UserEntity> getAllUnregisteredUsers();

    int updateUserRegistrationStatus(long id,boolean status);

    Optional<UserEntity> getUserById(long id);

    int updateBlockStatusById(long id,boolean isBlocked);
}
