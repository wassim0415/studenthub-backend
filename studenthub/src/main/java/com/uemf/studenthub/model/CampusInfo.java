package com.uemf.studenthub.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "campus_infos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CampusInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String serviceName; // ex: "Scolarité", "Infirmerie"

    private String email;
    
    private String phone;
    
    private String location; // ex: "Bâtiment Principal, RDC"

    @Column(nullable = false)
    private String category; // ex: "ADMINISTRATION", "SANTE", "LOGEMENT"
}