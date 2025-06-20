package com.example.demo.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiTransaction {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("process_id")
    private String processId;
    @JsonProperty("req_payload")
    private String reqPayload;
    @JsonProperty("res_payload")
    private String resPayload;
    @JsonProperty("status")
    private String status;
    @JsonProperty("created_at")
    private LocalDateTime createdAt;
    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;
} 