package com.example.demo.domain.model;

import lombok.Builder;

@Builder
public record RegistrationProfileRequest(
    String ref_id,
    String first_name,
    String last_name,
    String hkid,
    String passport_no,
    String gender,
    String contact_no,
    String DOB,
    String email,
    String opt_in
) {} 