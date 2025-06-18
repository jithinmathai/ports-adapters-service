package com.example.demo.api;

import com.example.demo.application.RegistrationProfileService;
import com.example.demo.domain.model.RegistrationProfileRequest;
import com.example.demo.domain.model.RegistrationProfileResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/registration/profile")
@RequiredArgsConstructor
public class RegistrationProfileController {
    private final RegistrationProfileService registrationProfileService;

    @PostMapping
    public ResponseEntity<RegistrationProfileResponse> registerProfile(@RequestBody RegistrationProfileRequest request) {
        RegistrationProfileResponse response = registrationProfileService.registerProfile(request);
        return ResponseEntity.ok(response);
    }
} 