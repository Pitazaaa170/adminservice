package com.pitaza.adminservice.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("app.kafka.producer")
@Getter
@Setter
@NoArgsConstructor
public class ProducerProperties {
    private String topic;
}
