package com.zonesoft.addressbook.controllers;

import com.zonesoft.addressbook.events.PersistenceEvent;
import com.zonesoft.addressbook.events.forwarders.PersistenceEventForwarder;

import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ServerSentEventController {
    private final Flux<PersistenceEvent> events;

    public ServerSentEventController(PersistenceEventForwarder eventPublisher) {
        this.events = Flux.create(eventPublisher).share();
    }

    @GetMapping(path = "/sse/persons", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
//    @CrossOrigin(origins = "http://localhost:3000")
    public Flux<String> profiles() {
        return this.events.map(event -> {
            	return event.getSource().toString();
        });
    }
}
