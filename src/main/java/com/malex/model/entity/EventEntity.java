package com.malex.model.entity;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class EventEntity {

    private Long id;

    private String text;

    private Long clientId;

    private LocalDateTime start;

    private LocalDateTime end;
}
