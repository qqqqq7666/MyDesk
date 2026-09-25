package com.jkc.mydesk.user.adapter.out.persistence;

import com.jkc.mydesk.user.domain.model.User;
import com.jkc.mydesk.user.application.port.out.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserRepository {
    private final UserJpaRepository jpaRepository;

    @Override
    public User save(User user) {
        UserJpaEntity entity = UserJpaEntity.from(user);
        
        UserJpaEntity savedEntity = jpaRepository.save(entity);
        
        return savedEntity.toDomain();
    }
}
