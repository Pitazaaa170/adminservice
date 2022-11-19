package com.pitaza.adminservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProcessRegistrationDto {
    private long userId;
    private boolean registrationApprove;
}
