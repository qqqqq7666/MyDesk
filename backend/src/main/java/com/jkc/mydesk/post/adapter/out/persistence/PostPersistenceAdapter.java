package com.jkc.mydesk.post.adapter.out.persistence;

import com.jkc.mydesk.post.application.port.out.PostPort;
import com.jkc.mydesk.post.application.port.out.PostQueryPort;
import com.jkc.mydesk.post.domain.model.Post;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.jkc.mydesk.post.adapter.out.persistence.QPostJpaEntity.postJpaEntity;

@Component
@RequiredArgsConstructor
public class PostPersistenceAdapter implements PostPort, PostQueryPort {

    private final PostJpaRepository jpaRepository;
    private final JPAQueryFactory queryFactory;

    @Override
    @Transactional
    public Post save(Post post) {
        PostJpaEntity entity = PostJpaEntity.from(post);

        return jpaRepository.save(entity).toDomain();
    }

    @Override
    @Transactional
    public Page<Post> search(Long folderId, String keyword, Pageable pageable) {
        List<Post> content = queryFactory
                .selectFrom(postJpaEntity)
                .where(
                        folderIdEq(folderId),
                        titleOrContentContains(keyword)
                )
                .orderBy(postJpaEntity.createdDate.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch()
                .stream()
                .map(PostJpaEntity::toDomain)
                .toList();

        return PageableExecutionUtils.getPage(content, pageable, () -> queryFactory
                .select(postJpaEntity.count())
                .from(postJpaEntity)
                .where(
                        folderIdEq(folderId),
                        titleOrContentContains(keyword)
                )
                .fetchOne());
    }

    private BooleanExpression folderIdEq(Long folderId) {
        return folderId != null ? postJpaEntity.folderId.eq(folderId) : null;
    }

    private BooleanExpression titleOrContentContains(String keyword) {
        if (!StringUtils.hasText(keyword)) {
            return null;
        }
        return postJpaEntity.title.contains(keyword)
                .or(postJpaEntity.content.contains(keyword));
    }
}
