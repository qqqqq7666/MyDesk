package com.jkc.mydesk.desk.adapter.in.web;

import com.jkc.mydesk.desk.adapter.in.web.dto.request.DeskSaveRequest;
import com.jkc.mydesk.desk.adapter.in.web.dto.response.DeskSaveResponse;
import com.jkc.mydesk.desk.domain.model.Desk;
import com.jkc.mydesk.user.adapter.out.persistence.UserJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class DeskWebMapper {
    public Desk toCommand(DeskSaveRequest request, UserJpaEntity owner) {
        return Desk.builder()
                .name(request.name())
                .description(request.description())
                .ownerId(owner.getId())
                .build();
    }

    public DeskSaveResponse toSaveResponse(Desk desk) {
        return DeskSaveResponse.builder()
                .name(desk.getName())
                .createdDate(desk.getCreatedDate())
                .build();
    }
}
