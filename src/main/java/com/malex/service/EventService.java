package com.malex.service;

import org.springframework.stereotype.Service;

import com.malex.mapper.ObjectMapper;
import com.malex.model.request.EventPartialUpdateRequest;
import com.malex.model.request.EventRequest;
import com.malex.model.response.EventResponse;
import com.malex.repository.EventEntityRepository;

import java.util.List;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EventService {

    private static final String EVENT_TEXT_FORMAT = "%s %s";

    private final ObjectMapper mapper;

    private final EventEntityRepository entityRepository;

    public List<EventResponse> findAll() {
        return entityRepository.findAll().stream().map(mapper::entityToResponse).toList();
    }

    public EventResponse create(EventRequest request) {
        var entity = mapper.requestToEntity(request);
        var persistEntity = entityRepository.save(entity);
        return mapper.entityToResponse(persistEntity);
    }

    public void deleteById(Long id) {
        entityRepository.deleteById(id);
    }

    public EventResponse partialUpdate(Long id, EventPartialUpdateRequest request) {
        throw new UnsupportedOperationException();
    }

}
