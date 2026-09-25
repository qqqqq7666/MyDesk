package com.jkc.mydesk.desk.adapter.in.web;

import com.jkc.mydesk.desk.adapter.in.web.dto.request.DeskSaveRequest;
import com.jkc.mydesk.desk.adapter.in.web.dto.response.DeskSaveResponse;
import com.jkc.mydesk.desk.domain.model.Desk;
import org.springframework.stereotype.Component;

@Component
public class DeskWebMapper {
    public Desk toCommand(DeskSaveRequest request) {
        return Desk.builder()
                .name(request.name())
                .description(request.description())
                .ownerId(request.ownerId())
                .build();
    }

    public DeskSaveResponse toSaveResponse(Desk desk) {
        return DeskSaveResponse.builder()
                .name(desk.getName())
                .createdDate(desk.getCreatedDate())
                .build();
    }
}
