package com.jkc.mydesk.folder.domain.model;

import com.jkc.mydesk.global.adapter.out.persistence.BaseEntity;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class Folder extends BaseEntity {
    private Long id;
    private String name;
    private Long deskId;
    private Long parentId;
}
