package com.jkc.mydesk.desk.application.service;

import com.jkc.mydesk.desk.application.port.in.DeskManagementUseCase;
import com.jkc.mydesk.desk.application.port.in.DeskQueryUseCase;
import com.jkc.mydesk.desk.application.port.out.DeskPort;
import com.jkc.mydesk.desk.domain.exception.DeskException;
import com.jkc.mydesk.desk.domain.model.Desk;
import com.jkc.mydesk.global.domain.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeskService implements
        DeskManagementUseCase,
        DeskQueryUseCase {

    private final DeskPort deskPort;

    @Override
    public Desk save(Desk request) {
        int deskCount = deskPort.getDeskCountByOwnerId(request.getOwnerId());

        if(deskCount >= 10) {
            throw new DeskException(ErrorCode.DESK_EXCEED_LIMIT);
        }

        return deskPort.save(request);
    }

    @Override
    public List<Desk> getDeskListByOwnerId(UUID ownerId) {
        return deskPort.getDeskListByOwnerId(ownerId);
    }
}
