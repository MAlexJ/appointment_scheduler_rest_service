package com.malex.model.entity;

import java.time.LocalDateTime;

public record ClientEntity(Long id, String firstName, String lastName, String info, LocalDateTime created,
                           LocalDateTime updated) {
}
