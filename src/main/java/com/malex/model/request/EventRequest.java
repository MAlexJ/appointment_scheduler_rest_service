package com.malex.model.request;

import java.time.LocalDateTime;
import java.util.Objects;

public record EventRequest(String text, LocalDateTime start, LocalDateTime end, Long clientId) {

    public EventRequest {
        Objects.requireNonNull(start, "Start cannot be null");
        Objects.requireNonNull(end, "End cannot be null");
        Objects.requireNonNull(clientId, "Client id cannot be null");
    }

}
