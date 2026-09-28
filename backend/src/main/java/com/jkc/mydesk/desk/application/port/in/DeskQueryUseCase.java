package com.jkc.mydesk.desk.application.port.in;

import com.jkc.mydesk.desk.domain.model.Desk;

import java.util.List;
import java.util.UUID;

public interface DeskQueryUseCase {
    List<Desk> getDeskListByOwnerId(UUID ownerId);
}
