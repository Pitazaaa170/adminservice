package com.pitaza.adminservice.kafka.consumer;

import com.pitaza.adminservice.kafka.message.AuthMessage;
import com.pitaza.adminservice.kafka.message.RegistrationApplicationMessage;
import com.pitaza.adminservice.dto.UserDto;
import com.pitaza.adminservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class RegistrationsConsumer {
    private final UserService userService;

    @KafkaListener(topics = "registration")
    public void receive(AuthMessage registrationApplicationMessage) {
        log.debug("Получены данные из топика registrations {}" , registrationApplicationMessage);
        userService.saveUser(new UserDto(registrationApplicationMessage.getId(),
                registrationApplicationMessage.getName(),
                registrationApplicationMessage.getSurname(),
                registrationApplicationMessage.getRole().name(),
                false,false
                ));
    }
}
