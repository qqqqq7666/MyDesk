package com.jkc.mydesk.desk.application.port.out;

import com.jkc.mydesk.desk.domain.model.Desk;

import java.util.List;
import java.util.UUID;

public interface DeskPort {
    Desk save(Desk desk);

    List<Desk> getDeskListByOwnerId(UUID ownerId);

    Integer getDeskCountByOwnerId(UUID ownerId);
}
