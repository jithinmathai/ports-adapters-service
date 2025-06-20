package com.example.demo.application;

import com.example.demo.domain.model.ApiResponse;
import com.example.demo.domain.model.RegistrationProfileRequest;
import com.example.demo.domain.model.RegistrationProfileResponse;

public interface RegistrationProfileService {
    ApiResponse<RegistrationProfileResponse> registerProfile(RegistrationProfileRequest request);
} 