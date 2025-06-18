package com.example.demo.application;

import com.example.demo.domain.model.RegistrationProfileRequest;
import com.example.demo.domain.model.RegistrationProfileResponse;
import com.example.demo.domain.model.RegistrationProfileResponse.Data;
import com.example.demo.domain.port.ApiTransactionPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RegistrationProfileServiceImpl implements RegistrationProfileService {
    private final ApiTransactionPort apiTransactionPort;

    @Override
    public RegistrationProfileResponse registerProfile(RegistrationProfileRequest request) {
        if (request == null) {
            throw new NullPointerException("RegistrationProfileRequest must not be null");
        }
        // Simulate external service call and response
        String processId = UUID.randomUUID().toString();
        String status = "pending";
        RegistrationProfileResponse.Data data = new Data(processId, status);
        RegistrationProfileResponse response = new RegistrationProfileResponse(0, "success", data);
        // Persist transaction
        apiTransactionPort.saveTransaction(processId, request, response, status);
        return response;
    }
} 