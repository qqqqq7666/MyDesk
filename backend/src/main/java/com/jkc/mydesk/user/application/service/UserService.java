package com.jkc.mydesk.user.application.service;

import com.jkc.mydesk.user.adapter.in.web.dto.request.UserRegisterRequest;
import com.jkc.mydesk.user.adapter.in.web.dto.response.UserRegisterResponse;
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
    public UserRegisterResponse register(UserRegisterRequest request) {
        User user = User.builder()
                .email(request.email())
                .password(request.password())
                .name(request.name())
                .build();
                
        User savedUser = userRepository.save(user);
        
        return new UserRegisterResponse(
                savedUser.getEmail(),
                savedUser.getCreatedDate()
        );
    }
}
