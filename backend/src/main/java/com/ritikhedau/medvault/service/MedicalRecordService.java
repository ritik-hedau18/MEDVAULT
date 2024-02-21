package com.ritikhedau.medvault.service;
import com.ritikhedau.medvault.entity.MedicalRecord;
import com.ritikhedau.medvault.repository.MedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
public class MedicalRecordService {
    @Autowired private MedicalRecordRepository repo;
    private static final String KEY = "12345678901234567890123456789012"; // 256 bit key

    private String encrypt(String val) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(KEY.getBytes(StandardCharsets.UTF_8), "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return Base64.getEncoder().encodeToString(cipher.doFinal(val.getBytes(StandardCharsets.UTF_8)));
    }

    private String decrypt(String val) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(KEY.getBytes(StandardCharsets.UTF_8), "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return new String(cipher.doFinal(Base64.getDecoder().decode(val)), StandardCharsets.UTF_8);
    }

    public MedicalRecord saveRecord(MedicalRecord rec) {
        try {
            rec.setPatientData(encrypt(rec.getPatientData()));
        } catch (Exception e) {
            throw new RuntimeException("Encryption failed", e);
        }
        return repo.save(rec);
    }

    public MedicalRecord getRecord(Long id) {
        MedicalRecord rec = repo.findById(id).orElse(null);
        if (rec != null) {
            try {
                rec.setPatientData(decrypt(rec.getPatientData()));
            } catch (Exception e) {
                throw new RuntimeException("Decryption failed", e);
            }
        }
        return rec;
    }
}