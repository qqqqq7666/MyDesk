package com.jkc.mydesk.space.domain.model;

import com.jkc.mydesk.user.domain.model.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Space {
    private Long id;
    private String name;
    private String description;

    private User owner;
}
