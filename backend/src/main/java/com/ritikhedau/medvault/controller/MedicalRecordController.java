package com.ritikhedau.medvault.controller;
import com.ritikhedau.medvault.entity.MedicalRecord;
import com.ritikhedau.medvault.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/records")
public class MedicalRecordController {
    @Autowired private MedicalRecordService service;

    @PostMapping
    public ResponseEntity<MedicalRecord> save(@RequestBody MedicalRecord rec) {
        return ResponseEntity.ok(service.saveRecord(rec));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicalRecord> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getRecord(id));
    }
}
// minor tweak: update verification rules and configs
