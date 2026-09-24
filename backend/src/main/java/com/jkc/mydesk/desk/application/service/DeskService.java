package com.jkc.mydesk.desk.application.service;

import com.jkc.mydesk.desk.adapter.in.web.DeskWebMapper;
import com.jkc.mydesk.desk.adapter.in.web.dto.request.DeskSaveRequest;
import com.jkc.mydesk.desk.adapter.in.web.dto.response.DeskSaveResponse;
import com.jkc.mydesk.desk.domain.repository.DeskRepository;
import com.jkc.mydesk.user.adapter.out.persistence.UserJpaEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeskService {
    private final DeskRepository deskRepository;
    private final DeskWebMapper webMapper;

    public DeskSaveResponse save(DeskSaveRequest request, UserJpaEntity owner) {

        return webMapper.toSaveResponse(
                deskRepository.save(webMapper.toCommand(request, owner))
        );
    }
}
