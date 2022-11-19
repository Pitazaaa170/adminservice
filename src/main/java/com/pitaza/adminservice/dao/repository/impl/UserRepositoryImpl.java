package com.pitaza.adminservice.dao.repository.impl;

import com.pitaza.adminservice.dao.entity.UserEntity;
import com.pitaza.adminservice.dao.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class UserRepositoryImpl implements UserRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    private static final String INSERT_NEW_USER = "INSERT INTO user_registrations(id,name,surname,role,is_registered) " +
            "VALUES (:id,:name,:surname,:role,:isRegistered)";
    private static final String SELECT_ALL_UNAPPROVED_REGISTRATIONS = "SELECT * FROM user_registrations " +
            "WHERE is_registered = false";
    private static final String UPDATE_USER_REGISTRATION = "UPDATE user_registrations " +
            "SET is_registered = :isRegistered " +
            "WHERE id = :id";
    private static final String SELECT_USER_BY_ID = "SELECT * " +
            "FROM user_registrations " +
            "WHERE id = :id";
    private static final String UPDATE_USER_BLOCK_STATUS = "UPDATE user_registrations " +
            "SET is_blocked = :is_blocked " +
            "WHERE id = :id";


    @Override
    public int saveUser(UserEntity userEntity) {
        log.debug("Вызван метод saveUser UserRepositoryImpl с аргументом {}",userEntity);
        return jdbcTemplate.update(INSERT_NEW_USER, Map.of("id", userEntity.getId(),
                "name", userEntity.getName(),
                "surname", userEntity.getSurname(),
                "role", userEntity.getRole(),
                "isRegistered", userEntity.isRegistered()));
    }

    @Override
    public List<UserEntity> getAllUnregisteredUsers() {
        try {
            return jdbcTemplate.query(SELECT_ALL_UNAPPROVED_REGISTRATIONS,(rs,rn) ->
                    new UserEntity(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("surname"),
                            rs.getString("role"),
                            rs.getBoolean("is_registered"),
                            rs.getBoolean("is_blocked"))
                    );
        } catch (Exception e) {
            log.warn("Ошибка во время исполнения sql запроса , {}",e.getMessage());
            return List.of();
        }
    }


    @Override
    public Optional<UserEntity> getUserById(long id) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(SELECT_USER_BY_ID,Map.of("id",id),
                    (rs,rn) ->
                            new UserEntity(rs.getInt("id"),
                                    rs.getString("name"),
                                    rs.getString("surname"),
                                    rs.getString("role"),
                                    rs.getBoolean("is_registered"),
                                    rs.getBoolean("is_blocked"))
            ));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public int updateBlockStatusById(long id,boolean isBlocked) {
        return jdbcTemplate.update(UPDATE_USER_BLOCK_STATUS,Map.of("is_blocked",isBlocked,"id",id));
    }

    @Override
    public int updateUserRegistrationStatus(long id,boolean isRegistered) {
        return jdbcTemplate.update(UPDATE_USER_REGISTRATION,Map.of("id", id,
                "isRegistered", isRegistered));
    }
}
