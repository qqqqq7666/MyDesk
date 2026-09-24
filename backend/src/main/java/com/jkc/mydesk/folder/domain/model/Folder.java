package com.jkc.mydesk.folder.domain.model;

import com.jkc.mydesk.common.adapter.out.persistence.BaseEntity;
import com.jkc.mydesk.desk.adapter.out.persistence.DeskJpaEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "p_folder")
public class Folder extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private DeskJpaEntity deskJpaEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    private Folder parent;
}
