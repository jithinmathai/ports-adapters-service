package com.example.demo.api;

import com.example.demo.application.RegistrationProfileService;
import com.example.demo.domain.model.ApiResponse;
import com.example.demo.domain.model.RegistrationProfileRequest;
import com.example.demo.domain.model.RegistrationProfileResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/registration/profile")
@RequiredArgsConstructor
public class RegistrationProfileController {
    private final RegistrationProfileService registrationProfileService;

    @PostMapping
    public ResponseEntity<ApiResponse<RegistrationProfileResponse>> registerProfile(@RequestBody RegistrationProfileRequest request) {
        log.info("Retrieved RegistrationProfileRequest, {}", request);
        ApiResponse<RegistrationProfileResponse> response = registrationProfileService.registerProfile(request);
        return ResponseEntity.ok(response);
    }
} 