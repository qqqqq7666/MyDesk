package com.jkc.mydesk.user.adapter.out.persistence;

import com.jkc.mydesk.common.adapter.out.persistence.BaseEntity;
import com.jkc.mydesk.user.domain.model.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Entity
@Table(name = "p_user")
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserJpaEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String name;

    public static UserJpaEntity from(User user) {
        return UserJpaEntity.builder()
                .id(user.getId())
                .email(user.getEmail())
                .password(user.getPassword())
                .name(user.getName())
                .createdDate(user.getCreatedDate())
                .createdBy(user.getCreatedBy())
                .lastModifiedDate(user.getLastModifiedDate())
                .lastModifiedBy(user.getLastModifiedBy())
                .build();
    }

    public User toDomain() {
        return User.builder()
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
}
