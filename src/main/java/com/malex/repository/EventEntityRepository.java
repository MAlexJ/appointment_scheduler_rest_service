package com.malex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.malex.model.entity.EventEntity;

@Repository
public interface EventEntityRepository extends JpaRepository<EventEntity, Long> {
}
