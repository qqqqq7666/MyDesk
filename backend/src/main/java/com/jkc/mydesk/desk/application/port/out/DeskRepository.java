package com.jkc.mydesk.desk.domain.repository;

import com.jkc.mydesk.desk.domain.model.Desk;

public interface DeskRepository {
    Desk save(Desk desk);
}
