package com.jkc.mydesk.folder.adapter.out.persistence;

import com.jkc.mydesk.desk.adapter.out.persistence.QDeskJpaEntity;
import com.jkc.mydesk.folder.application.port.out.FolderPort;
import com.jkc.mydesk.folder.application.port.out.FolderQueryPort;
import com.jkc.mydesk.folder.domain.model.Folder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class FolderPersistenceAdapter implements
        FolderPort,
        FolderQueryPort {

    private final FolderJpaRepository jpaRepository;
    private final JPAQueryFactory queryFactory;

    @Override
    public Folder save(Folder folder) {
        FolderJpaEntity entity = FolderJpaEntity.from(folder);

        FolderJpaEntity savedEntity = jpaRepository.save(entity);

        return savedEntity.toDomain();
    }

    @Override
    public List<Folder> findFolderList(UUID userId, Long parentId) {
        QFolderJpaEntity qFolder = QFolderJpaEntity.folderJpaEntity;
        QDeskJpaEntity qDesk = QDeskJpaEntity.deskJpaEntity;

        return queryFactory
                .selectFrom(qFolder)
                .join(qDesk)
                .on(qFolder.deskId.eq(qDesk.id))
                .where(
                        qDesk.ownerId.eq(userId),
                        parentId == null
                                ? qFolder.parentId.isNull()
                                : qFolder.parentId.eq(parentId)
                )
                .orderBy(qFolder.name.asc())
                .fetch()
                .stream()
                .map(FolderJpaEntity::toDomain)
                .toList();
    }
}
