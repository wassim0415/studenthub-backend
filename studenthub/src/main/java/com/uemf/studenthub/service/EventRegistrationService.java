package com.uemf.studenthub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.uemf.studenthub.model.Event;
import com.uemf.studenthub.model.EventRegistration;
import com.uemf.studenthub.repository.EventRegistrationRepository; // Nouvel import
import com.uemf.studenthub.repository.EventRepository;

@Service
public class EventRegistrationService {

    @Autowired
    private EventRegistrationRepository registrationRepository;

    @Autowired
    private EventRepository eventRepository; // Injection de EventRepository

    public EventRegistration createRegistration(EventRegistration registration) {
        // 1. Récupérer l'événement depuis la base de données
        Event event = eventRepository.findById(registration.getEvent().getId())
                .orElseThrow(() -> new RuntimeException("Événement non trouvé"));

        // 2. Vérifier si l'événement a une capacité maximale définie
        if (event.getMaxCapacity() != null) {
            // 3. Compter le nombre d'inscrits actuels
            long currentRegistrations = registrationRepository.countByEventId(event.getId());

            // 4. Bloquer l'inscription si la capacité est atteinte
            if (currentRegistrations >= event.getMaxCapacity()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cet événement est complet.");
            }
        }

        // 5. Si tout est OK, sauvegarder l'inscription
        return registrationRepository.save(registration);
    }

    public List<EventRegistration> getAllRegistrations() {
        return registrationRepository.findAll();
    }

    public List<EventRegistration> getRegistrationsByUserId(Long userId) {
        return registrationRepository.findByUserId(userId);
    }
}