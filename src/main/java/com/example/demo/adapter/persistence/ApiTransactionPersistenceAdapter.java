package com.example.demo.adapter.persistence;

import com.example.demo.domain.model.ApiResponse;
import com.example.demo.domain.model.RegistrationProfileRequest;
import com.example.demo.domain.model.RegistrationProfileResponse;
import com.example.demo.domain.port.ApiTransactionPort;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
@RequiredArgsConstructor
@Component
public class ApiTransactionPersistenceAdapter implements ApiTransactionPort {
    private final ApiTransactionRepository repository;
    private final ObjectMapper objectMapper;

    @Override
    public void saveTransaction(String processId, RegistrationProfileRequest request, ApiResponse<RegistrationProfileResponse> response, String status) {
        try {
            String reqPayload = objectMapper.writeValueAsString(request);
            String resPayload = objectMapper.writeValueAsString(response.getData());
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
            log.error("Error serializing transaction data", e);
            throw new RuntimeException("Error serializing transaction data", e);
        }
    }
} 