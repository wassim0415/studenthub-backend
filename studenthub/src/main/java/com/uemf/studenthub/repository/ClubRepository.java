package com.uemf.studenthub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uemf.studenthub.model.Club;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long> {
}