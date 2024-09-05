package com.malex.model.response;

import java.time.LocalDateTime;

public record EventResponse(Long id, String text, LocalDateTime start, LocalDateTime end) {
}
