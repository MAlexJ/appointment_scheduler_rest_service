package com.malex.service;

import org.springframework.stereotype.Service;

import com.malex.mapper.ObjectMapper;
import com.malex.model.request.EventPartialUpdateRequest;
import com.malex.model.request.EventRequest;
import com.malex.model.response.EventResponse;
import com.malex.repository.ClientRepository;
import com.malex.repository.EventEntityRepository;

import java.util.List;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EventService {

    private final ObjectMapper mapper;

    private final EventEntityRepository entityRepository;

    private final ClientRepository clientRepository;


    public List<EventResponse> findAll() {
        return entityRepository.findAll().stream().map(mapper::entityToResponse).toList();
    }

    public EventResponse create(EventRequest request) {
        var clientId = request.clientId();
        var client = clientRepository.findById(clientId).orElseThrow();

        var entity = mapper.requestToEntity(request);
        entity.setText(String.format("%s %s", client.getFirstName(), client.getLastName()));
        entity.setClient(client);

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
