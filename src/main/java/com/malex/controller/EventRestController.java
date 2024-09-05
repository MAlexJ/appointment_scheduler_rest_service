package com.malex.controller;

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

@Slf4j
@RestController
@RequestMapping("/api/v1/events")
@RequiredArgsConstructor
public class EventRestController {

    private final EventService service;

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<EventResponse>> findAllEventsByCriteria() {
        log.info("Received request for findAllEvents");
        return ResponseEntity.notFound().build();
    }


    @CrossOrigin
    @PostMapping
    public ResponseEntity<EventResponse> createEvent(@RequestBody EventRequest request) {
        log.info("Received request for createEvent: {}", request);
        return ResponseEntity.notFound().build();
    }


    @CrossOrigin
    @PutMapping
    public ResponseEntity<String> put(@RequestBody String request) {
        log.info("Received request for put: {}", request);
        return ResponseEntity.notFound().build();
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
    @CrossOrigin
    @PatchMapping("/{id}")
    public ResponseEntity<EventResponse> partialUpdate(@PathVariable int id,
                                                       @RequestBody EventPartialUpdateRequest request) {
        log.info("Received request for patch by id: {}, body: {}", id, request);
        return ResponseEntity.notFound().build();
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        log.info("Delete event by id: {}", id);
        return ResponseEntity.notFound().build();
    }
}
