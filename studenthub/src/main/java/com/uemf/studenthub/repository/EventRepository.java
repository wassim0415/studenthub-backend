package com.uemf.studenthub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uemf.studenthub.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByOrganizerId(Long organizerId);
    // Trouve tous les événements d'une catégorie spécifique
    List<Event> findByCategory(String category);
}