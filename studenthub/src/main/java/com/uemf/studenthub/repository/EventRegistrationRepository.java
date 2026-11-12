package com.uemf.studenthub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository; // N'oubliez pas cet import pour utiliser "List"

import com.uemf.studenthub.model.EventRegistration;

@Repository
public interface EventRegistrationRepository extends JpaRepository<EventRegistration, Long> {
    
    // 1. Permet de récupérer tous les événements d'un étudiant spécifique (Mon Planning)
    List<EventRegistration> findByUserId(Long userId);

    // 2. Permet de compter combien de personnes sont déjà inscrites à un événement (Quota)
    long countByEventId(Long eventId);
}