package com.malex.service;

import org.springframework.stereotype.Service;

import com.malex.mapper.ObjectMapper;
import com.malex.model.entity.ClientEntity;
import com.malex.model.request.ClientRequest;
import com.malex.model.response.ClientResponse;
import com.malex.repository.ClientRepository;

import java.util.List;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ObjectMapper mapper;

    private final ClientRepository clientRepository;

    public ClientResponse create(ClientRequest request) {
        var entity = mapper.requestToEntity(request);
        ClientEntity persistEntity = clientRepository.save(entity);
        return mapper.entityToResponse(persistEntity);
    }

    public List<ClientResponse> findAll() {
        return clientRepository.findAll().stream().map(mapper::entityToResponse).toList();
    }
}
