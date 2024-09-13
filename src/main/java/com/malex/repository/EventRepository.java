package com.malex.repository;

import org.springframework.stereotype.Repository;

import com.malex.model.entity.EventEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class EventRepository {

    private final AtomicLong idGenerator = new AtomicLong();

    private final List<EventEntity> entities;


    public List<EventEntity> findAll() {
        return entities;
    }

    public EventEntity save(EventEntity entity) {
        EventEntity persistEntity = generateId(entity);
        entities.add(persistEntity);
        return persistEntity;
    }

    public void deleteById(Long id) {
        findById(id).map(entities::remove);
    }

    public EventEntity partialUpdateById(Long id, LocalDateTime start, LocalDateTime end) {
        return findById(id) //
                .map(entity -> {
                    deleteById(id);
                    return entity;
                }) //
                .map(entity -> updateEntityTime(entity, start, end)) //
                .map(entity -> {
                    entities.add(entity);
                    return entity;
                }).orElseThrow();
    }

    public Optional<EventEntity> findById(Long id) {
        return entities.stream().filter(entity -> entity.getId().equals(id)).findFirst();
    }


    private EventEntity generateId(EventEntity entity) {
        entity.setId(idGenerator.incrementAndGet());
        return entity;
    }

    private EventEntity updateEntityTime(EventEntity entity, LocalDateTime start, LocalDateTime end) {
        entity.setStart(start);
        entity.setEnd(end);
        return entity;
    }

}
