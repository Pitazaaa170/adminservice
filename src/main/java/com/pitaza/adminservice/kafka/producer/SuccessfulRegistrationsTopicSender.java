package com.pitaza.adminservice.kafka.producer;

import com.pitaza.adminservice.kafka.message.SuccessfulRegistrationMessage;

public interface SuccessfulRegistrationsTopicSender {
    void sendMessage(SuccessfulRegistrationMessage successfulRegistrationMessage);
}
