package com.jkc.mydesk.user.application.port.out;

import com.jkc.mydesk.user.domain.model.User;

import java.util.UUID;

public interface UserPort {
    User save(User user);

    User findById(UUID userId);

    Boolean existsById(UUID userId);
}
