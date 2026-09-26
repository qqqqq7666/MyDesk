package com.jkc.mydesk.file.adapter.out.persistence;

import com.jkc.mydesk.common.adapter.out.persistence.BaseEntity;
import com.jkc.mydesk.file.domain.model.File;
import com.jkc.mydesk.file.domain.model.FileUploadStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@SuperBuilder
@Table(name = "p_file")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FileJpaEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long folderId;
    @Column(nullable = false)
    private String originalName;
    // file path
    @Column(nullable = false)
    private String objectKey;
    @Column(nullable = false)
    private String contentType;
    @Column(nullable = false)
    private long size;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private FileUploadStatus uploadStatus;

    public static FileJpaEntity from(File file) {
        return FileJpaEntity.builder()
                .id(file.getId())
                .folderId(file.getFolderId())
                .originalName(file.getOriginalName())
                .objectKey(file.getObjectKey())
                .contentType(file.getContentType())
                .size(file.getSize())
                .uploadStatus(file.getUploadStatus())
                .createdDate(file.getCreatedDate())
                .createdBy(file.getCreatedBy())
                .lastModifiedDate(file.getLastModifiedDate())
                .lastModifiedBy(file.getLastModifiedBy())
                .build();
    }

    public File toDomain() {
        return File.builder()
                .id(id)
                .folderId(folderId)
                .originalName(originalName)
                .objectKey(objectKey)
                .contentType(contentType)
                .size(size)
                .uploadStatus(uploadStatus)
                .createdDate(this.getCreatedDate())
                .createdBy(this.getCreatedBy())
                .lastModifiedDate(this.getLastModifiedDate())
                .lastModifiedBy(this.getLastModifiedBy())
                .build();
    }
}
