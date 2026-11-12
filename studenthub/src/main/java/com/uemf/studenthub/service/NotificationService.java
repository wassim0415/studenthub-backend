package com.uemf.studenthub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uemf.studenthub.model.Notification;
import com.uemf.studenthub.repository.NotificationRepository;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public Notification createNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    public List<Notification> getUserNotifications(Long userId) {
        return notificationRepository.findByUserIdOrderBySentDateDesc(userId);
    }
    
    // Méthode bonus : Marquer une notification comme lue
    public Notification markAsRead(Long id) {
        Notification notif = notificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notification introuvable"));
        notif.setRead(true);
        return notificationRepository.save(notif);
    }
}