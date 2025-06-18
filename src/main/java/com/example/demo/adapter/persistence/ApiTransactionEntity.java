package com.example.demo.adapter.persistence;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "api_transactions")
@Getter
@Setter
@AllArgsConstructor
@Builder
public class ApiTransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "process_id", nullable = false)
    private String processId;

    @Column(name = "req_payload", columnDefinition = "jsonb", nullable = false)
    private String reqPayload;

    @Column(name = "res_payload", columnDefinition = "jsonb")
    private String resPayload;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
} 