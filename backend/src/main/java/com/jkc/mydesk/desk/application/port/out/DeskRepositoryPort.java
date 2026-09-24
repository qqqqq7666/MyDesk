package com.jkc.mydesk.desk.application.port.out;

import com.jkc.mydesk.desk.adapter.out.persistence.DeskJapRepository;
import com.jkc.mydesk.desk.adapter.out.persistence.DeskJpaEntity;
import com.jkc.mydesk.desk.adapter.out.persistence.DeskPersistenceMapper;
import com.jkc.mydesk.desk.domain.model.Desk;
import com.jkc.mydesk.desk.domain.repository.DeskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeskRepositoryPort implements DeskRepository {
    private final DeskJapRepository deskJapRepository;
    private final DeskPersistenceMapper persistenceMapper;

    @Override
    public Desk save(Desk desk) {
        DeskJpaEntity entity = persistenceMapper.toEntity(desk);

        return persistenceMapper.toDomain(
                deskJapRepository.save(entity)
        );
    }
}
