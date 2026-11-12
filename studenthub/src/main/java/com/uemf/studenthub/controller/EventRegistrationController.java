package com.uemf.studenthub.controller;

import com.uemf.studenthub.model.EventRegistration;
import com.uemf.studenthub.service.EventRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/registrations")
public class EventRegistrationController {

    @Autowired
    private EventRegistrationService registrationService;

    @PostMapping
    public EventRegistration register(@RequestBody EventRegistration registration) {
        return registrationService.createRegistration(registration);
    }

    @GetMapping
    public List<EventRegistration> getRegistrations() {
        return registrationService.getAllRegistrations();
    }
}