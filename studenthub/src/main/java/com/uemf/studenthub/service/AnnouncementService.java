package com.uemf.studenthub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uemf.studenthub.model.Announcement;
import com.uemf.studenthub.repository.AnnouncementRepository;

@Service
public class AnnouncementService {

    @Autowired
    private AnnouncementRepository announcementRepository;

    public Announcement createAnnouncement(Announcement announcement) {
        return announcementRepository.save(announcement);
    }

    public List<Announcement> getLatestAnnouncements() {
        return announcementRepository.findAllByOrderByPublishDateDesc();
    }
}