package com.malex.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.malex.model.entity.ClientEntity;

@Repository
public interface ClientRepository extends CrudRepository<ClientEntity, Long> {
}
