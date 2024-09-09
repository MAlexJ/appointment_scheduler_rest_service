package com.malex.repository;

import java.util.concurrent.atomic.AtomicLong;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ClientRepository {

    private final AtomicLong idGenerator = new AtomicLong();

}
