package com.malex.service;

import org.springframework.stereotype.Service;

import com.malex.mapper.ObjectMapper;
import com.malex.model.request.EventPartialUpdateRequest;
import com.malex.model.request.EventRequest;
import com.malex.model.response.EventResponse;
import com.malex.repository.EventRepository;

import java.util.List;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EventService {

    private final ObjectMapper mapper;

    private final EventRepository eventRepository;


    public List<EventResponse> findAll() {
        return eventRepository.findAll().stream().map(mapper::entityToResponse).toList();
    }

    public EventResponse create(EventRequest request) {
        var entity = mapper.requestToEntity(request);
        var persistEntity = eventRepository.save(entity);
        return mapper.entityToResponse(persistEntity);
    }

    public void deleteById(Long id) {
        eventRepository.deleteById(id);
    }

    public EventResponse partialUpdate(Long id, EventPartialUpdateRequest request) {
        var eventEntity = eventRepository.partialUpdateById(id, request.start(), request.end());
        return mapper.entityToResponse(eventEntity);
    }
}
