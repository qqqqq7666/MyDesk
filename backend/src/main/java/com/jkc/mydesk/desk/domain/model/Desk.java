package com.jkc.mydesk.desk.domain.model;

import com.jkc.mydesk.common.domain.model.BaseModel;
import com.jkc.mydesk.user.adapter.out.persistence.UserJpaEntity;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class Desk extends BaseModel {
    private Long id;
    private String name;
    private String description;

    private UserJpaEntity owner;
}
