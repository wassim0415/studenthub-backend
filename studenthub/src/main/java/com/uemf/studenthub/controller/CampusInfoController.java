package com.uemf.studenthub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uemf.studenthub.model.CampusInfo;
import com.uemf.studenthub.service.CampusInfoService;

@RestController
@RequestMapping("/api/campus-info")
public class CampusInfoController {

    @Autowired
    private CampusInfoService campusInfoService;

    @PostMapping
    public CampusInfo createInfo(@RequestBody CampusInfo info) {
        return campusInfoService.createInfo(info);
    }

    @GetMapping
    public List<CampusInfo> getAllInfos() {
        return campusInfoService.getAllInfos();
    }

    @GetMapping("/filter")
    public List<CampusInfo> getInfosByCategory(@RequestParam String category) {
        return campusInfoService.getInfosByCategory(category);
    }
}