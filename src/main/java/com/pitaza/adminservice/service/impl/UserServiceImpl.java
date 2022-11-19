package com.pitaza.adminservice.service.impl;

import com.pitaza.adminservice.dao.entity.UserEntity;
import com.pitaza.adminservice.dao.repository.UserRepository;
import com.pitaza.adminservice.dto.ProcessRegistrationDto;
import com.pitaza.adminservice.dto.UserDto;
import com.pitaza.adminservice.exception.UserNotFoundException;
import com.pitaza.adminservice.kafka.message.SuccessfulRegistrationMessage;
import com.pitaza.adminservice.kafka.producer.SuccessfulRegistrationsTopicSender;
import com.pitaza.adminservice.mapper.impl.UserMapper;
import com.pitaza.adminservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final SuccessfulRegistrationsTopicSender successfulRegistrationsTopicSender;


    @Override
    public void saveUser(UserDto userDto) {
        userRepository.saveUser(new UserEntity(userDto.getId(),
                userDto.getName(),
                userDto.getSurname(),
                userDto.getRole(),
                false,false));
    }

    @Override
    public List<UserDto> getUnregisteredUsers() {
        var allUnregisteredUsers = userRepository.getAllUnregisteredUsers();
        return allUnregisteredUsers.stream()
                .map(userMapper::mapFrom)
                .collect(Collectors.toList());
    }

    @Override
    public void processRegistration(ProcessRegistrationDto processRegistrationDto) {
        userRepository.updateUserRegistrationStatus(processRegistrationDto.getUserId(), processRegistrationDto.isRegistrationApprove());
        if (processRegistrationDto.isRegistrationApprove()) {
            successfulRegistrationsTopicSender.sendMessage(new SuccessfulRegistrationMessage(processRegistrationDto.getUserId()));
        }
    }

    @Override
    public UserDto getUserById(long id) {
        var maybeUser = userRepository.getUserById(id);
        if (maybeUser.isPresent()) {
            return userMapper.mapFrom(maybeUser.get());
        }
        throw new UserNotFoundException(id);
    }

    @Override
    public void blockUserById(long id) {
        userRepository.updateBlockStatusById(id,true);
//        accountServiceClient.postUserBlocked(id);
    }

    @Override
    public void unBlockUserById(long id) {
        userRepository.updateBlockStatusById(id,false);
//        accountServiceClient.postUserUnblocked(id);
    }
}
