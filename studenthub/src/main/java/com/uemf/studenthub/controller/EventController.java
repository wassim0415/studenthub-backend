package com.uemf.studenthub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uemf.studenthub.model.Event;
import com.uemf.studenthub.service.EventService;

@RestController
@RequestMapping("/api/events") // L'URL de base pour les événements
public class EventController {

    @Autowired
    private EventService eventService;

    // Quand le Flutter fait un GET sur /api/events, cette méthode est appelée
    @GetMapping
    public List<Event> getEvents() {
        return eventService.getAllEvents();
    }
    
    // Quand le Flutter fait un POST sur /api/events avec des données, cette méthode crée l'événement
    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        return eventService.saveEvent(event);
    }
    @GetMapping("/filter")
    public List<Event> getEventsByCategory(@RequestParam String category) {
    return eventService.getEventsByCategory(category);
    }
}