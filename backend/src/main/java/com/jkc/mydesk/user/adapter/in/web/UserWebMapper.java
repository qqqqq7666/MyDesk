package com.jkc.mydesk.user.adapter.in.web;

import com.jkc.mydesk.user.adapter.in.web.dto.request.UserRegisterRequest;
import com.jkc.mydesk.user.adapter.in.web.dto.response.UserRegisterResponse;
import com.jkc.mydesk.user.domain.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserWebMapper {
    public User toDomain(UserRegisterRequest request) {
        return User.builder()
                .email(request.email())
                .password(request.password())
                .name(request.name())
                .build();
    }

    public UserRegisterResponse toRegisterResponse(User user) {
        return UserRegisterResponse.builder()
                .email(user.getEmail())
                .createdDate(user.getCreatedDate())
                .build();
    }
}
