package com.malex.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.malex.model.request.EventPartialUpdateRequest;
import com.malex.model.request.EventRequest;
import com.malex.model.response.EventResponse;
import com.malex.service.EventService;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin
@Slf4j
@RestController
@RequestMapping("/api/v1/events")
@RequiredArgsConstructor
public class EventRestController {

    private final EventService service;

    @GetMapping
    public ResponseEntity<List<EventResponse>> findAllEventsByCriteria() {
        log.trace("Http: find all events by criteria");
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<EventResponse> createEvent(@RequestBody EventRequest request) {
        log.trace("Http: create new event - {}", request);
        return ResponseEntity.ok(service.create(request));
    }

    /*
     * 4.7. Remove a device or configuration
     * link: https://restfulapi.net/rest-api-design-tutorial-with-example/
     *
     * 1. async operation
     *  A successful response SHOULD be 202 (Accepted) if the resource has been queued for deletion (async operation),
     *
     * 2. sync operation
     *  or 200 (OK) / 204 (No Content) if the resource has been deleted permanently (sync operation).
     *
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        log.trace("Http: delete event by id: {}", id);
        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    /*
     * When a client needs to replace an existing Resource entirely, they can use PUT. When they’re
     * doing a partial update, they can use HTTP PATCH.
     *
     * PATCH:
     * link: https://stackoverflow.com/questions/28459418/use-of-put-vs-patch-methods-in-rest-api-real-life-scenarios
     *
     * <p>parameters:
     * id - event id
     *
     * json {
     *  start - new event start date
     *  end - new event end date
     * }
     */
    @PatchMapping("/{id}")
    public ResponseEntity<EventResponse> partialUpdate(@PathVariable Long id,
                                                       @RequestBody EventPartialUpdateRequest request) {
        log.trace("Http: partial event update by id: {}, request: {}", id, request);
        return ResponseEntity.ok(service.partialUpdate(id, request));
    }

    @PutMapping
    public ResponseEntity<String> put(@RequestBody String request) {
        log.info("Http: update event: {}", request);
        return ResponseEntity.notFound().build();
    }
}
