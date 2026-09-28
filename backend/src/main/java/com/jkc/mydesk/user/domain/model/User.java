package com.jkc.mydesk.user.domain.model;

import com.jkc.mydesk.global.domain.model.BaseModel;
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
