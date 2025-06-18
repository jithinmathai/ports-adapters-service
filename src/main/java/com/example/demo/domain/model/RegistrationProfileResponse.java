package com.example.demo.domain.model;

import lombok.Builder;

@Builder
public record RegistrationProfileResponse(
    int code,
    String msg,
    Data data
) {
    @Builder
    public record Data(String process_id, String status) {}
} 