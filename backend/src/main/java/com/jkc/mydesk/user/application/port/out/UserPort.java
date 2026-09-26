package com.jkc.mydesk.user.application.port.out;

import com.jkc.mydesk.user.domain.model.User;

public interface UserRepository {
    User save(User user);
}
