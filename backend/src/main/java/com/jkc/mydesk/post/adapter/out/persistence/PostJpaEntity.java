package com.jkc.mydesk.post.adapter.out.persistence;

import com.jkc.mydesk.common.adapter.out.persistence.BaseEntity;
import com.jkc.mydesk.folder.adapter.out.persistence.FolderJpaEntity;
import com.jkc.mydesk.post.domain.model.Post;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "p_post")
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostJpaEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long folderId;
    @Column(nullable = false)
    private String title;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String content;

    public static PostJpaEntity from(Post post) {
        return PostJpaEntity.builder()
                .id(post.getId())
                .folderId(post.getFolderId())
                .title(post.getTitle())
                .content(post.getContent())
                .createdDate(post.getCreatedDate())
                .createdBy(post.getCreatedBy())
                .lastModifiedDate(post.getLastModifiedDate())
                .lastModifiedBy(post.getLastModifiedBy())
                .build();
    }

    public Post toDomain() {
        return Post.builder()
                .id(id)
                .folderId(folderId)
                .title(title)
                .content(content)
                .createdDate(this.getCreatedDate())
                .createdBy(this.getCreatedBy())
                .lastModifiedDate(this.getLastModifiedDate())
                .lastModifiedBy(this.getLastModifiedBy())
                .build();
    }
}
