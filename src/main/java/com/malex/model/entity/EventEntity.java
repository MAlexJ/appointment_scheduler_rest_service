package com.malex.model.entity;

import java.time.LocalDateTime;

public record EventEntity(Long id, String text, Long clientId, LocalDateTime start, LocalDateTime end) {
}
