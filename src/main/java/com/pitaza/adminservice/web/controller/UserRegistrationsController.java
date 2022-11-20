package com.pitaza.adminservice.web.controller;

import com.pitaza.adminservice.dto.ProcessRegistrationDto;
import com.pitaza.adminservice.dto.UserDto;
import com.pitaza.adminservice.service.UserService;
import com.pitaza.adminservice.web.api.ProcessRegistrationRequest;
import com.pitaza.adminservice.web.api.RegisteredUsersResponse;
import com.pitaza.adminservice.web.api.UnregisteredUsersResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("${app.name}/v1")
public class UserRegistrationsController {
    private final UserService userService;


    @GetMapping("/registrations")
    public ResponseEntity<UnregisteredUsersResponse> getAllUnregisteredUsers() {
        return ResponseEntity.ok(new UnregisteredUsersResponse(userService.getUnregisteredUsers()));
    }

    @GetMapping("user/registered")
    public ResponseEntity<RegisteredUsersResponse> getAllRegisteredUsers() {
        return ResponseEntity.ok(new RegisteredUsersResponse(userService.getRegisteredUsers()));
    }
    @PutMapping("/registration")
    public ResponseEntity<?> processRegistration(
            @RequestBody ProcessRegistrationRequest processRegistrationRequest
            ) {
        userService.processRegistration(new ProcessRegistrationDto(processRegistrationRequest.getUserId(),processRegistrationRequest.isRegistrationApprove()));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserDto> getUserById(
            @PathVariable long id
    ) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping("/user/block/{id}")
    public ResponseEntity<?> blockUserById(
            @PathVariable long id
    ) {
        userService.blockUserById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/user/unblock/{id}")
    public ResponseEntity<?> unblockUserById(
            @PathVariable long id
    ) {
        userService.unBlockUserById(id);
        return ResponseEntity.ok().build();
    }
}
