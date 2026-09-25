package com.jkc.mydesk.desk.adapter.out.persistence;

import com.jkc.mydesk.desk.domain.model.Desk;
import com.jkc.mydesk.desk.application.port.out.DeskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeskPersistenceAdapter implements DeskRepository {
    private final DeskJapRepository deskJapRepository;

    @Override
    public Desk save(Desk desk) {
        DeskJpaEntity entity = DeskJpaEntity.from(desk);

        return deskJapRepository.save(entity)
                .toDomain();
    }
}
