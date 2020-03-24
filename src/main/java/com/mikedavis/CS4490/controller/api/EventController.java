package com.mikedavis.CS4490.controller.api;

import com.mikedavis.CS4490.model.AdditionalMetadata;
import com.mikedavis.CS4490.model.Event;
import com.mikedavis.CS4490.service.sql.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/events")
public class EventController {
    @Autowired
    EventService eventService;

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public ResponseEntity<String> addEvent(@RequestBody Event event){
        eventService.addEvent(event);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
