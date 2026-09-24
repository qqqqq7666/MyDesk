package com.jkc.mydesk.space.adapter.out.persistence;

import com.jkc.mydesk.common.domain.model.BaseEntity;
import com.jkc.mydesk.user.domain.model.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Table(name = "p_space")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SpaceJpaEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;


    @OneToOne(fetch = FetchType.LAZY)
    private User owner;
}
