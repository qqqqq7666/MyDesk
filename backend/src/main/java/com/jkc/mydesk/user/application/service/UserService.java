package com.jkc.mydesk.user.application.service;

import com.jkc.mydesk.user.application.port.in.UserManagementUseCase;
import com.jkc.mydesk.user.application.port.out.UserPort;
import com.jkc.mydesk.user.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements
        UserManagementUseCase {

    private final UserPort userPort;

    @Override
    public User register(User request) {

        return userPort.save(request);
    }
}
