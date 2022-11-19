package com.pitaza.adminservice.kafka.producer.impl;

import com.pitaza.adminservice.config.ProducerProperties;
import com.pitaza.adminservice.kafka.message.SuccessfulRegistrationMessage;
import com.pitaza.adminservice.kafka.producer.SuccessfulRegistrationsTopicSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class SuccessfulRegistrationsTopicSenderImpl implements SuccessfulRegistrationsTopicSender {
    private final KafkaTemplate<String,Object> kafkaTemplate;
    private final ProducerProperties producerProperties;


    @Override
    public void sendMessage(SuccessfulRegistrationMessage successfulRegistrationMessage) {
        try {
            kafkaTemplate.send(producerProperties.getTopic(),successfulRegistrationMessage);
        } catch (Exception e){
            log.warn("Ошибка при отправке сообщения в топик , {}",e.getMessage());
        }
    }
}
