package com.jkc.mydesk.desk.application.service;

import com.jkc.mydesk.desk.adapter.in.web.DeskWebMapper;
import com.jkc.mydesk.desk.adapter.in.web.dto.request.DeskSaveRequest;
import com.jkc.mydesk.desk.adapter.in.web.dto.response.DeskSaveResponse;
import com.jkc.mydesk.desk.application.port.in.DeskManagementUseCase;
import com.jkc.mydesk.desk.application.port.out.DeskRepository;
import com.jkc.mydesk.user.adapter.out.persistence.UserJpaEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeskService implements DeskManagementUseCase {
    private final DeskRepository deskRepository;
    private final DeskWebMapper webMapper;

    @Override
    public DeskSaveResponse save(DeskSaveRequest request) {

        return webMapper.toSaveResponse(
                deskRepository.save(webMapper.toCommand(request))
        );
    }
}
