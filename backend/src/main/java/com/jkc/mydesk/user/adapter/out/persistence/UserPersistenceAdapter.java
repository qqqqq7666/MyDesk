package com.jkc.mydesk.user.adapter.out.persistence;

import com.jkc.mydesk.global.domain.exception.ErrorCode;
import com.jkc.mydesk.user.domain.exception.UserException;
import com.jkc.mydesk.user.domain.model.User;
import com.jkc.mydesk.user.application.port.out.UserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserPort {
    private final UserJpaRepository jpaRepository;

    @Override
    @Transactional
    public User save(User user) {
        UserJpaEntity entity = UserJpaEntity.from(user);
        
        UserJpaEntity savedEntity = jpaRepository.save(entity);
        
        return savedEntity.toDomain();
    }

    @Override
    public User findById(UUID userId) {
        UserJpaEntity entity = jpaRepository.findById(userId)
                .orElseThrow(() -> new UserException(ErrorCode.USER_NOT_FOUND));

        return entity.toDomain();
    }

    @Override
    public Boolean existsById(UUID userId) {
        return jpaRepository.existsById(userId);
    }
}
