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
}
