package com.jkc.mydesk.desk.application.service;

import com.jkc.mydesk.desk.adapter.in.web.DeskWebMapper;
import com.jkc.mydesk.desk.adapter.in.web.dto.request.DeskSaveRequest;
import com.jkc.mydesk.desk.adapter.in.web.dto.response.DeskSaveResponse;
import com.jkc.mydesk.desk.application.port.in.DeskManagementUseCase;
import com.jkc.mydesk.desk.application.port.out.DeskRepository;
import com.jkc.mydesk.desk.domain.model.Desk;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeskService implements DeskManagementUseCase {
    private final DeskRepository deskRepository;

    @Override
    public Desk save(Desk request) {

        return deskRepository.save(request);
    }
}
