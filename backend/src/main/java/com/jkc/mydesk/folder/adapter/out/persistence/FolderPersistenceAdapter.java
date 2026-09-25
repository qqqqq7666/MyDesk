package com.jkc.mydesk.folder.adapter.out.persistence;

import com.jkc.mydesk.folder.application.port.out.FolderRepository;
import com.jkc.mydesk.folder.domain.model.Folder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FolderPersistenceAdapter implements FolderRepository {
    private final FolderJpaRepository jpaRepository;

    @Override
    public Folder save(Folder folder) {
        FolderJpaEntity entity = FolderJpaEntity.from(folder);

        FolderJpaEntity savedEntity = jpaRepository.save(entity);

        return savedEntity.toDomain();
    }
}
