package com.malex.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.malex.model.entity.ClientEntity;
import com.malex.model.entity.EventEntity;
import com.malex.model.request.ClientRequest;
import com.malex.model.request.EventRequest;
import com.malex.model.response.ClientResponse;
import com.malex.model.response.EventResponse;

/*
 * MapStruct mapper:
 */
@Mapper(componentModel = "spring")
public interface ObjectMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "client", ignore = true)
    EventEntity requestToEntity(EventRequest request);

    @Mapping(target = "id", ignore = true)
    ClientEntity requestToEntity(ClientRequest request);

    EventResponse entityToResponse(EventEntity entity);

    ClientResponse entityToResponse(ClientEntity entity);
}
