package com.ritikhedau.medvault.service;
import org.springframework.stereotype.Service;

@Service
public class AccessGrantService {
    public String performAction(String action) {
        return "Action '" + action + "' processed successfully in AccessGrantService.";
    }
// minor tweak: performance check updates
}