package com.ritikhedau.medvault.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "access_grants")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class AccessGrant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long patientId;

    private Long doctorId;

    private String accessCode; // QR shared verification code

    private LocalDateTime expiresAt;

    private String status; // ACTIVE, EXPIRED, REVOKED

    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        if (status == null) status = "ACTIVE";
    }
}
