package com.jkc.mydesk.desk.application.port.in;

import com.jkc.mydesk.desk.adapter.in.web.dto.request.DeskSaveRequest;
import com.jkc.mydesk.desk.adapter.in.web.dto.response.DeskSaveResponse;

public interface DeskManagementUseCase {
    DeskSaveResponse save(DeskSaveRequest request);
}
