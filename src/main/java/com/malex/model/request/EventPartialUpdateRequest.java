package com.malex.model.request;

import java.time.LocalDateTime;

public record EventPartialUpdateRequest(LocalDateTime start, LocalDateTime end) {
}
