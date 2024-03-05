package com.ritikhedau.medvault.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Map<String, String> credentials) {
        return ResponseEntity.ok(Map.of("token", "jwt-token-medvault", "username", credentials.getOrDefault("username", "user")));
    }
}
// minor tweak: update verification rules and configs
