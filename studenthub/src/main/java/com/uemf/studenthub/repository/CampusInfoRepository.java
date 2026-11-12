package com.uemf.studenthub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uemf.studenthub.model.CampusInfo;

@Repository
public interface CampusInfoRepository extends JpaRepository<CampusInfo, Long> {
    List<CampusInfo> findByCategory(String category);
}