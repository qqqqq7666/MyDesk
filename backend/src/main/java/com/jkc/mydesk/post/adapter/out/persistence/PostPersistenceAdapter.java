package com.jkc.mydesk.post.adapter.out.persistence;

import com.jkc.mydesk.post.application.port.out.PostRepository;
import com.jkc.mydesk.post.domain.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostPersistenceAdapter implements PostRepository {

    private final PostJpaRepository jpaRepository;

    @Override
    public Post save(Post post) {
        PostJpaEntity entity = PostJpaEntity.from(post);

        return jpaRepository.save(entity).toDomain();
    }
}
