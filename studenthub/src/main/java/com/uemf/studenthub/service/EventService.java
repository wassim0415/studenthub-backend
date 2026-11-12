package com.uemf.studenthub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uemf.studenthub.model.Event;
import com.uemf.studenthub.repository.EventRepository;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    // Fonction pour récupérer tous les événements
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    // Fonction pour sauvegarder un nouvel événement dans la base de données
    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }
    public List<Event> getEventsByCategory(String category) {
    return eventRepository.findByCategory(category);
    }
}