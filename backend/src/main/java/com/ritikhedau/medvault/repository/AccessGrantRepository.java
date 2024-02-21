package com.ritikhedau.medvault.repository;

import com.ritikhedau.medvault.entity.AccessGrant;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface AccessGrantRepository extends JpaRepository<AccessGrant, Long> {
    List<AccessGrant> findByPatientId(Long patientId);
    List<AccessGrant> findByDoctorId(Long doctorId);
    Optional<AccessGrant> findByAccessCode(String accessCode);
}
