package com.jkc.mydesk.desk.adapter.out.persistence;

import com.jkc.mydesk.common.adapter.out.persistence.BaseEntity;
import com.jkc.mydesk.desk.domain.model.Desk;
import com.jkc.mydesk.user.adapter.out.persistence.UserJpaEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Entity
@Getter
@SuperBuilder
@Table(name = "p_desk")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DeskJpaEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    private UUID ownerId;

    public static DeskJpaEntity from(Desk desk) {
        return DeskJpaEntity.builder()
                .id(desk.getId())
                .name(desk.getName())
                .description(desk.getDescription())
                .ownerId(desk.getOwnerId())
                .createdDate(desk.getCreatedDate())
                .createdBy(desk.getCreatedBy())
                .lastModifiedDate(desk.getLastModifiedDate())
                .lastModifiedBy(desk.getLastModifiedBy())
                .build();
    }

    public Desk toDomain() {
        return Desk.builder()
                .id(id)
                .name(name)
                .description(description)
                .ownerId(ownerId)
                .createdDate(this.getCreatedDate())
                .createdBy(this.getCreatedBy())
                .lastModifiedDate(this.getLastModifiedDate())
                .lastModifiedBy(this.getLastModifiedBy())
                .build();
    }
}
