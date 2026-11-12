package com.uemf.studenthub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uemf.studenthub.model.Club;
import com.uemf.studenthub.repository.ClubRepository;

@Service
public class ClubService {

    @Autowired
    private ClubRepository clubRepository;

    public Club createClub(Club club) {
        return clubRepository.save(club);
    }

    public List<Club> getAllClubs() {
        return clubRepository.findAll();
    }
}