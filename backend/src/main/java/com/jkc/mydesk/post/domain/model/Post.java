package com.jkc.mydesk.post.domain.model;

import com.jkc.mydesk.common.adapter.out.persistence.BaseEntity;
import com.jkc.mydesk.folder.domain.model.Folder;
import jakarta.persistence.*;

@Entity
@Table(name = "p_post")
public class Post extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Folder folder;

    private String title;

    @Lob
    private String content;
}
