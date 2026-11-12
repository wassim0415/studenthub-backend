package com.uemf.studenthub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.uemf.studenthub.model.User;
import com.uemf.studenthub.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // L'outil injecté depuis SecurityConfig pour crypter les mots de passe
    @Autowired
    private PasswordEncoder passwordEncoder;

    // Récupérer tous les utilisateurs
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Créer un nouvel utilisateur
    public User saveUser(User user) {
        // 1. On crypte le mot de passe reçu en texte clair
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        
        // 2. On sauvegarde l'utilisateur dans la base de données
        return userRepository.save(user);
    }
}