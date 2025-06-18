package com.example.demo.domain.port;

import com.example.demo.domain.model.RegistrationProfileRequest;
import com.example.demo.domain.model.RegistrationProfileResponse;

public interface ApiTransactionPort {
    void saveTransaction(String processId, RegistrationProfileRequest request, RegistrationProfileResponse response, String status);
} 