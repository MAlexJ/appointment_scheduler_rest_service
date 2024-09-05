package com.malex.model.request;

import java.time.LocalDateTime;

public record EventRequest(String text, LocalDateTime start, LocalDateTime end) {
}
