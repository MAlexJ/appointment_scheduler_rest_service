package com.malex.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.malex.model.entity.EventEntity;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public List<EventEntity> entities() {
        return new ArrayList<>();
    }
}
