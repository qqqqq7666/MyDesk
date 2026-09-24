package com.jkc.mydesk.user.domain.model;

import com.jkc.mydesk.common.domain.model.BaseModel;
import com.jkc.mydesk.user.adapter.out.persistence.UserJpaEntity;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Getter
@SuperBuilder
public class User extends BaseModel {
    private UUID id;
    private String email;
    private String password;
    private String name;

    public UserJpaEntity toEntity() {
        return UserJpaEntity.builder()
                .id(id)
                .email(email)
                .password(password)
                .name(name)
                .createdDate(this.getCreatedDate())
                .createdBy(this.getCreatedBy())
                .lastModifiedDate(this.getLastModifiedDate())
                .lastModifiedBy(this.getLastModifiedBy())
                .build();

    }

    public static User from(UserJpaEntity entity) {
        return User.builder()
                .id(entity.getId())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .name(entity.getName())
                .createdDate(entity.getCreatedDate())
                .createdBy(entity.getCreatedBy())
                .lastModifiedDate(entity.getLastModifiedDate())
                .lastModifiedBy(entity.getLastModifiedBy())
                .build();

    }
}
