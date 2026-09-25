package com.jkc.mydesk.desk.domain.model;

import com.jkc.mydesk.common.domain.model.BaseModel;
import com.jkc.mydesk.user.domain.model.User;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Getter
@SuperBuilder
public class Desk extends BaseModel {
    private Long id;
    private String name;
    private String description;

    private UUID ownerId;
}
