package com.ritikhedau.medvault.controller;

import com.ritikhedau.medvault.entity.AccessGrant;
import com.ritikhedau.medvault.repository.AccessGrantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/grants")
public class AccessGrantController {
    @Autowired
    private AccessGrantRepository repository;

    @GetMapping
    public ResponseEntity<List<AccessGrant>> list() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping
    public ResponseEntity<AccessGrant> create(@RequestBody AccessGrant grant) {
        return ResponseEntity.ok(repository.save(grant));
    }
}
// minor tweak: update verification rules and configs
