package com.jkc.mydesk.user.adapter.in.web.dto.request;

public record UserRegisterRequest(
        String email,
        String password,
        String name
) {
}
