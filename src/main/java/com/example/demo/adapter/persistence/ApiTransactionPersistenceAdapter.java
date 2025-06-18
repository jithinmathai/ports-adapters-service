package com.example.demo.adapter.persistence;

import com.example.demo.domain.model.RegistrationProfileRequest;
import com.example.demo.domain.model.RegistrationProfileResponse;
import com.example.demo.domain.port.ApiTransactionPort;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class ApiTransactionPersistenceAdapter implements ApiTransactionPort {
    private final ApiTransactionRepository repository;
    private final ObjectMapper objectMapper;

    @Override
    public void saveTransaction(String processId, RegistrationProfileRequest request, RegistrationProfileResponse response, String status) {
        try {
            String reqPayload = objectMapper.writeValueAsString(request);
            String resPayload = objectMapper.writeValueAsString(response);
            ApiTransactionEntity entity = ApiTransactionEntity.builder()
                .processId(processId)
                .reqPayload(reqPayload)
                .resPayload(resPayload)
                .status(status)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
            repository.save(entity);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save API transaction", e);
        }
    }
} 