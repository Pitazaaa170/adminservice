package com.pitaza.adminservice.web.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProcessRegistrationRequest {
    private long userId;
    private boolean registrationApprove;
}
