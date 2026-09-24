package com.jkc.mydesk.file.domain.model;

import com.jkc.mydesk.common.adapter.out.persistence.BaseEntity;
import com.jkc.mydesk.folder.domain.model.Folder;
import jakarta.persistence.*;

@Entity
@Table(name = "p_file")
public class File extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Folder folder;

    private String originalName;

    private String storedName;

    private String storagePath;

    private String contentType;

    private Long size;
}
