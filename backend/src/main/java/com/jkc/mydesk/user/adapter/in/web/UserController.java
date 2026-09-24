package com.jkc.mydesk.user.adapter.in.web;

import com.jkc.mydesk.user.adapter.in.web.dto.request.UserRegisterRequest;
import com.jkc.mydesk.user.adapter.in.web.dto.response.UserRegisterResponse;
import com.jkc.mydesk.user.application.port.in.UserManagementUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserManagementUseCase userManagementUseCase;

    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponse> signup(@RequestBody UserRegisterRequest request) {
        UserRegisterResponse response = userManagementUseCase.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
