package com.jkc.mydesk.desk.application.port.in;

import com.jkc.mydesk.desk.domain.model.Desk;

public interface DeskManagementUseCase {
    Desk save(Desk request);
}
