package com.jkc.mydesk.desk.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface DeskJapRepository extends JpaRepository<DeskJpaEntity, Long> {
    List<DeskJpaEntity> findAllByOwnerId(UUID ownerId);

    Integer countByOwnerId(UUID ownerId);
}
