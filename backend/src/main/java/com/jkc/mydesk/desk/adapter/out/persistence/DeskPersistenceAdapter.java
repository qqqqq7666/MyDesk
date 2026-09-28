package com.jkc.mydesk.desk.adapter.out.persistence;

import com.jkc.mydesk.desk.domain.model.Desk;
import com.jkc.mydesk.desk.application.port.out.DeskPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DeskPersistenceAdapter implements DeskPort {
    private final DeskJapRepository deskJapRepository;

    @Override
    public Desk save(Desk desk) {
        DeskJpaEntity entity = DeskJpaEntity.from(desk);

        return deskJapRepository.save(entity)
                .toDomain();
    }

    @Override
    public List<Desk> getDeskListByOwnerId(UUID ownerId) {

        return deskJapRepository.findAllByOwnerId(ownerId).stream()
                .map(DeskJpaEntity::toDomain)
                .toList();
    }

    @Override
    public Integer getDeskCountByOwnerId(UUID ownerId) {
        return deskJapRepository.countByOwnerId(ownerId);
    }
}
