package com.example.demo.domain.model;

import lombok.Builder;
import java.time.LocalDateTime;

@Builder
public record ApiTransaction(
    Long id,
    String processId,
    String reqPayload,
    String resPayload,
    String status,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {} 