package com.example.demo.application;

import com.example.demo.domain.model.RegistrationProfileRequest;
import com.example.demo.domain.model.RegistrationProfileResponse;

public interface RegistrationProfileService {
    RegistrationProfileResponse registerProfile(RegistrationProfileRequest request);
} 