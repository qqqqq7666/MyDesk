package com.jkc.mydesk.desk.adapter.out.persistence;

import com.jkc.mydesk.common.adapter.out.persistence.BaseEntity;
import com.jkc.mydesk.user.adapter.out.persistence.UserJpaEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

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


    @OneToOne(fetch = FetchType.LAZY)
    private UserJpaEntity owner;
}
