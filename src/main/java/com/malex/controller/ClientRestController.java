package com.malex.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.malex.model.request.ClientRequest;
import com.malex.model.response.ClientResponse;
import com.malex.service.ClientService;

@CrossOrigin
@Slf4j
@RestController
@RequestMapping("/api/v1/clients")
@RequiredArgsConstructor
public class ClientRestController {

    private final ClientService clientService;

    @GetMapping
    public ResponseEntity<List<ClientResponse>> findAll() {
        log.trace("Http: find all clients by criteria");
        return ResponseEntity.ok(clientService.findAll());
    }

    @PostMapping
    public ResponseEntity<ClientResponse> create(@RequestBody ClientRequest request) {
        log.trace("Http: create new client - {}", request);
        return ResponseEntity.ok(clientService.create(request));
    }

}
