package com.jkc.mydesk.space.domain.repository;

import com.jkc.mydesk.space.domain.model.Space;

import java.util.Optional;

public interface SpaceRepository {
    Space save(Space space);
}
