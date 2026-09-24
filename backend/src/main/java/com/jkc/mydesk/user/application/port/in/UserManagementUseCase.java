package com.jkc.mydesk.user.application.port.in;

import com.jkc.mydesk.user.adapter.in.web.dto.request.UserRegisterRequest;
import com.jkc.mydesk.user.adapter.in.web.dto.response.UserRegisterResponse;

public interface UserManagementUseCase {
    UserRegisterResponse register(UserRegisterRequest request);
}
