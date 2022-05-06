package com.walmart.registration.token;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {

    private final ConfirmationTokenRepository confirmationTokenRepository;

    public void saveConfirmationToken(ConfirmationToken token){
        confirmationTokenRepository.save(token);
    }

    public Optional<ConfirmationToken> getToken(String token) {
        return confirmationTokenRepository.findByToken(token);
    }

    public void setConfirmedAt(String token) {
        confirmationTokenRepository.updateConfirmedAt(
                token, LocalDateTime.now());
    }

//    public int setNewExpiresAt(String token, String newToken) {
//        return confirmationTokenRepository.add15minutesToExpiresAt(
//                token, LocalDateTime.now().plusMinutes(15), newToken);
//    }

    public void setNewExpiresAt(String token) {
        confirmationTokenRepository.add15minutesToExpiresAt(
                token, LocalDateTime.now().plusMinutes(15));
    }
}
