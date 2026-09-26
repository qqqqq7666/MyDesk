package com.jkc.mydesk.user.application.service;

import com.jkc.mydesk.user.application.port.in.UserManagementUseCase;
import com.jkc.mydesk.user.application.port.out.UserRepository;
import com.jkc.mydesk.user.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements
        UserManagementUseCase {

    private final UserRepository userRepository;

    @Override
    public User register(User request) {

        return userRepository.save(request);
    }
}
