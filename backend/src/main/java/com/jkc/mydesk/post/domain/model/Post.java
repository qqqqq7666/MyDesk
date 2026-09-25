package com.jkc.mydesk.post.domain.model;

import com.jkc.mydesk.common.domain.model.BaseModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class Post extends BaseModel {
    private Long id;
    private Long folderId;
    private String title;
    private String content;
}
