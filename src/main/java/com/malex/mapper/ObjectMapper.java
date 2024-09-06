package com.malex.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.malex.model.entity.EventEntity;
import com.malex.model.request.EventRequest;
import com.malex.model.response.EventResponse;

/*
 * MapStruct mapper:
 */
@Mapper(componentModel = "spring")
public interface ObjectMapper {

    @Mapping(target = "id", ignore = true)
    EventEntity requestToEntity(EventRequest request);

    EventResponse entityToResponse(EventEntity entity);
}
