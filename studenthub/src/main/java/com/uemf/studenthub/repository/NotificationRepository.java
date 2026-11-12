package com.uemf.studenthub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uemf.studenthub.model.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    
    // Récupère les notifications d'un utilisateur, de la plus récente à la plus ancienne
    List<Notification> findByUserIdOrderBySentDateDesc(Long userId);
}