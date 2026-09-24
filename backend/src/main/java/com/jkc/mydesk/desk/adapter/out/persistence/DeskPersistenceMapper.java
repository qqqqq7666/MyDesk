package com.jkc.mydesk.desk.adapter.out.persistence;

import com.jkc.mydesk.desk.domain.model.Desk;
import org.springframework.stereotype.Component;

@Component
public class DeskPersistenceMapper {
    public DeskJpaEntity toEntity(Desk desk) {
        return DeskJpaEntity.builder()
                .id(desk.getId())
                .owner(desk.getOwner())
                .name(desk.getName())
                .description(desk.getDescription())
                .build();
    }

    public Desk toDomain(DeskJpaEntity entity) {
        return Desk.builder()
                .id(entity.getId())
                .owner(entity.getOwner())
                .name(entity.getName())
                .description(entity.getDescription())
                .createdDate(entity.getCreatedDate())
                .createdBy(entity.getCreatedBy())
                .lastModifiedDate(entity.getLastModifiedDate())
                .lastModifiedBy(entity.getLastModifiedBy())
                .build();
    }
}
