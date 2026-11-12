package com.uemf.studenthub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uemf.studenthub.model.Announcement;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
    
    // Récupère les annonces triées de la plus récente à la plus ancienne
    List<Announcement> findAllByOrderByPublishDateDesc();
}