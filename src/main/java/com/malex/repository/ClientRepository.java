package com.malex.repository;

import org.springframework.stereotype.Repository;

import com.malex.model.entity.ClientEntity;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ClientRepository {

    private final AtomicLong idGenerator = new AtomicLong();

    private final List<ClientEntity> clients;

    public ClientEntity save(ClientEntity entity) {
        ClientEntity persistEntity = generateId(entity);
        clients.add(persistEntity);
        return persistEntity;
    }


    public List<ClientEntity> findAll() {
        return clients;
    }


    private ClientEntity generateId(ClientEntity entity) {
        return new ClientEntity(idGenerator.incrementAndGet(), entity.firstName(), entity.lastName(),
                entity.phoneNumber(), entity.info());
    }
}