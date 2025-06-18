package com.example.demo.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationProfileResponse {
    @JsonProperty("code")
    private int code;
    @JsonProperty("msg")
    private String msg;
    @JsonProperty("data")
    private Data data;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @lombok.Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Data {
        @JsonProperty("process_id")
        private String processId;
        @JsonProperty("status")
        private String status;
    }
} 