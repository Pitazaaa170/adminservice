package com.pitaza.adminservice.integration.rest.impl;

import com.pitaza.adminservice.config.AccountServiceProperties;
import com.pitaza.adminservice.integration.rest.AccountServiceClient;
import com.pitaza.adminservice.integration.rest.api.AccountServiceStatusResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
@RequiredArgsConstructor
@Slf4j
public class AccountServiceClientImpl implements AccountServiceClient {
    private final RestTemplate restTemplate;
    private final AccountServiceProperties accountServiceProperties;

    @Override
    public ResponseEntity<AccountServiceStatusResponse> putUserBlocked(long id) {
        log.debug("Вызван метод postUserBlocked c id {}",id);
        var urlWithoutParams = accountServiceProperties.getSocket() + accountServiceProperties.getChangeStatusUrl();
        var urlWithParams = String.format(urlWithoutParams,id,"true");
        return restTemplate.exchange(urlWithParams, HttpMethod.PUT,null, AccountServiceStatusResponse.class, Map.of());
    }

    @Override
    public ResponseEntity<AccountServiceStatusResponse> putUserUnblocked(long id) {
        var urlWithoutParams = accountServiceProperties.getSocket() + accountServiceProperties.getChangeStatusUrl();
        var urlWithParams = String.format(urlWithoutParams,id,"false");
        return restTemplate.exchange(urlWithParams, HttpMethod.PUT,null, AccountServiceStatusResponse.class, Map.of());
    }
}
