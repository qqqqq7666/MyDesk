package com.jkc.mydesk.user.application.port.out;

import com.jkc.mydesk.user.domain.model.User;

public interface UserRepositoryPort {
    User save(User user);
}
