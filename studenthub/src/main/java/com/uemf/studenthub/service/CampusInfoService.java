package com.uemf.studenthub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uemf.studenthub.model.CampusInfo;
import com.uemf.studenthub.repository.CampusInfoRepository;

@Service
public class CampusInfoService {

    @Autowired
    private CampusInfoRepository campusInfoRepository;

    public CampusInfo createInfo(CampusInfo info) {
        return campusInfoRepository.save(info);
    }

    public List<CampusInfo> getAllInfos() {
        return campusInfoRepository.findAll();
    }

    public List<CampusInfo> getInfosByCategory(String category) {
        return campusInfoRepository.findByCategory(category);
    }
}