package com.jkc.mydesk.desk.application.port.out;

import com.jkc.mydesk.desk.domain.model.Desk;

public interface DeskRepository {
    Desk save(Desk desk);
}
