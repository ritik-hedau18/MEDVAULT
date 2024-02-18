package com.ritikhedau.medvault.entity;

import com.ritikhedau.medvault.config.JpaEncryptionConverter;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "medical_records")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class MedicalRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long patientId;

    private String recordName;

    private String documentType; // BLOOD_TEST, XRAY, PRESCRIPTION

    // JPA field-level AES encryption converter to protect patient privacy at rest
    @Convert(converter = JpaEncryptionConverter.class)
    @Column(columnDefinition = "TEXT")
    private String parsedContentJson;

    @Convert(converter = JpaEncryptionConverter.class)
    private String hashString;

    private LocalDateTime uploadedAt;

    @PrePersist
    protected void onCreate() {
        uploadedAt = LocalDateTime.now();
    }
}
