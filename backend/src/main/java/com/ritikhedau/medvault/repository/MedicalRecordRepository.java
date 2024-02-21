package com.ritikhedau.medvault.repository;

import com.ritikhedau.medvault.entity.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {
    List<MedicalRecord> findByPatientId(Long patientId);
}

// minor tweak: update verification rules and configs
