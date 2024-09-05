package com.malex.model.entity;

import java.time.LocalDateTime;

public record EventEntity(Long id, String text, LocalDateTime start, LocalDateTime end) {
}
