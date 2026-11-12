package com.uemf.studenthub.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uemf.studenthub.model.AuthRequest;
import com.uemf.studenthub.security.JwtUtil;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            // 1. On vérifie si l'email et le mot de passe sont corrects
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword())
            );
        } catch (Exception e) {
            throw new Exception("Email ou mot de passe incorrect");
        }

        // 2. Si c'est bon, on récupère l'utilisateur
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getEmail());

        // 3. On demande à l'usine de fabriquer le fameux token JWT
        final String jwt = jwtUtil.generateToken(userDetails.getUsername());

        // 4. On renvoie le token à l'application mobile (Flutter)
        Map<String, String> response = new HashMap<>();
        response.put("token", jwt);
        return response;
    }
}