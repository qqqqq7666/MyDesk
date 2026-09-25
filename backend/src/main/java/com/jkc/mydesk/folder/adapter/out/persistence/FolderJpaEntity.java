package com.jkc.mydesk.folder.adapter.out.persistence;

import com.jkc.mydesk.common.adapter.out.persistence.BaseEntity;
import com.jkc.mydesk.desk.adapter.out.persistence.DeskJpaEntity;
import com.jkc.mydesk.folder.domain.model.Folder;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@Entity
@SuperBuilder
@Table(name = "p_folder")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FolderJpaEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Long deskId;
    @Column
    private Long parentId;

    public static FolderJpaEntity from(Folder folder) {
        return FolderJpaEntity.builder()
                .id(folder.getId())
                .name(folder.getName())
                .deskId(folder.getDeskId())
                .parentId(folder.getParentId())
                .createdDate(folder.getCreatedDate())
                .createdBy(folder.getCreatedBy())
                .lastModifiedDate(folder.getLastModifiedDate())
                .lastModifiedBy(folder.getLastModifiedBy())
                .build();
    }

    public Folder toDomain() {
        return Folder.builder()
                .id(id)
                .name(name)
                .deskId(deskId)
                .parentId(parentId)
                .createdDate(this.getCreatedDate())
                .createdBy(this.getCreatedBy())
                .lastModifiedDate(this.getLastModifiedDate())
                .lastModifiedBy(this.getLastModifiedBy())
                .build();
    }
}
