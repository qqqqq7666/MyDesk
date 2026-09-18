package com.jkc.mydesk.folder.domain.model;

import com.jkc.mydesk.common.domain.model.BaseEntity;
import com.jkc.mydesk.space.domain.model.Space;
import jakarta.persistence.*;

@Entity
@Table(name = "p_folder")
public class Folder extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Space space;

    @ManyToOne(fetch = FetchType.LAZY)
    private Folder parent;
}
