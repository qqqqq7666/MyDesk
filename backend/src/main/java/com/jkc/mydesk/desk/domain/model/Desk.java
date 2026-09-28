package com.jkc.mydesk.desk.domain.model;

import com.jkc.mydesk.global.domain.model.BaseModel;
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
