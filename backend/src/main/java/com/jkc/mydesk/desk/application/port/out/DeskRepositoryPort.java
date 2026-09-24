package com.jkc.mydesk.space.application.port.out;

import com.jkc.mydesk.space.adapter.out.persistence.SpaceJapRepository;
import com.jkc.mydesk.space.adapter.out.persistence.SpacePersistenceMapper;
import com.jkc.mydesk.space.domain.model.Space;
import com.jkc.mydesk.space.domain.repository.SpaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class SpaceRepositoryPort implements SpaceRepository {
    private final SpaceJapRepository spaceJapRepository;
    private final SpacePersistenceMapper persistenceMapper;

    @Override
    public Space save(Space space) {
        return spaceJapRepository.save(
                persistenceMapper.toEntity(space)
        );
    }
}
