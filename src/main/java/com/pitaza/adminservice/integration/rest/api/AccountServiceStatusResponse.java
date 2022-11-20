package com.pitaza.adminservice.integration.rest.api;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class AccountServiceStatusResponse {
    private String message;
    private Object data;

}
