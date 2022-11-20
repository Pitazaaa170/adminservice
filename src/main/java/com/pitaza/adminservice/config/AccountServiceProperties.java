package com.pitaza.adminservice.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app.integrations.rest.account-service")
@NoArgsConstructor
@Setter
@Getter
public class AccountServiceProperties {
    private String socket;
    private String changeStatusUrl;
}
