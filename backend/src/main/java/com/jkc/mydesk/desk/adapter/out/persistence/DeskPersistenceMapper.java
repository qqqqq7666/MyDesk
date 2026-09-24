package com.jkc.mydesk.space.adapter.out.persistence;

import com.jkc.mydesk.space.domain.model.Space;
import org.springframework.stereotype.Component;

@Component
public class SpacePersistenceMapper {
    public SpaceJpaEntity toEntity(Space space) {
        return SpaceJpaEntity.builder()
                .id(space.getId())
                .owner(space.getOwner())
                .name(space.getName())
                .description(space.getDescription())
                .build();
    }

    public Space toDomain(SpaceJpaEntity entity) {
        return Space.builder()
                .id(entity.getId())
                .owner(entity.getOwner())
                .name(entity.getName())
                .description(entity.getDescription())
                .build();
    }
}
