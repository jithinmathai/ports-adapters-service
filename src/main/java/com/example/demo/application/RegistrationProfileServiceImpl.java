package com.example.demo.application;

import com.example.demo.domain.model.ApiResponse;
import com.example.demo.domain.model.RegistrationProfileRequest;
import com.example.demo.domain.model.RegistrationProfileResponse;
import com.example.demo.domain.port.ApiTransactionPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class RegistrationProfileServiceImpl implements RegistrationProfileService {
    private final ApiTransactionPort apiTransactionPort;

    @Override
    public ApiResponse<RegistrationProfileResponse> registerProfile(RegistrationProfileRequest request) {
        if (request == null) {
            throw new NullPointerException("Request cannot be null");
        }
        String processId = UUID.randomUUID().toString();
        log.info("Generated process id: {}", processId);
        var data = RegistrationProfileResponse.builder()
                .processId(processId)
                .status("pending")
                .build();
        var response = new ApiResponse<>(0, "success", data);
        apiTransactionPort.saveTransaction(processId, request, response, "pending");
        return response;
    }
} 