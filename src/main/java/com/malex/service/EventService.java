package com.malex.service;

import org.springframework.stereotype.Service;

import com.malex.mapper.ObjectMapper;
import com.malex.model.request.EventPartialUpdateRequest;
import com.malex.model.request.EventRequest;
import com.malex.model.response.EventResponse;
import com.malex.repository.EventRepositoryStub;

import java.util.List;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EventService {

    private final ObjectMapper mapper;

    private final EventRepositoryStub eventRepositoryStub;


    public List<EventResponse> findAll() {
        return eventRepositoryStub.findAll().stream().map(mapper::entityToResponse).toList();
    }

    public EventResponse create(EventRequest request) {
        var entity = mapper.requestToEntity(request);
        var persistEntity = eventRepositoryStub.save(entity);
        return mapper.entityToResponse(persistEntity);
    }

    public void deleteById(Long id) {
        eventRepositoryStub.deleteById(id);
    }

    public EventResponse partialUpdate(Long id, EventPartialUpdateRequest request) {
        var eventEntity = eventRepositoryStub.partialUpdateById(id, request.start(), request.end());
        return mapper.entityToResponse(eventEntity);
    }
}
