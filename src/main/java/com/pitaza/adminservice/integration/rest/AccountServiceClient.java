package com.pitaza.adminservice.integration.rest;

import com.pitaza.adminservice.integration.rest.api.AccountServiceStatusResponse;
import org.springframework.http.ResponseEntity;

public interface AccountServiceClient {

    ResponseEntity<AccountServiceStatusResponse> putUserBlocked(long id);

    ResponseEntity<AccountServiceStatusResponse> putUserUnblocked(long id);
}
