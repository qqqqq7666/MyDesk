package com.jkc.mydesk.space.domain.model;

import com.jkc.mydesk.common.domain.model.BaseEntity;
import com.jkc.mydesk.user.domain.model.User;
import jakarta.persistence.*;

@Entity
@Table(name = "p_space")
public class Space extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;


    @OneToOne(fetch = FetchType.LAZY)
    private User owner;
}
