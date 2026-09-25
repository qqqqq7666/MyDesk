package com.jkc.mydesk.file.domain.model;

import com.jkc.mydesk.common.adapter.out.persistence.BaseEntity;
import com.jkc.mydesk.folder.adapter.out.persistence.FolderJpaEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "p_file")
public class File extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private FolderJpaEntity folderJpaEntity;

    private String originalName;

    private String storedName;

    private String storagePath;

    private String contentType;

    private Long size;
}
