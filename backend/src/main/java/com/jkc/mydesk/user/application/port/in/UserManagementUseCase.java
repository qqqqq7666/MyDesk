package com.jkc.mydesk.user.application.port.in;

import com.jkc.mydesk.user.domain.model.User;

public interface UserManagementUseCase {
    User register(User request);
}
