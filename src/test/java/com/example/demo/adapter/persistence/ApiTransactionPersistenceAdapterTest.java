package com.example.demo.adapter.persistence;

import com.example.demo.domain.model.ApiResponse;
import com.example.demo.domain.model.RegistrationProfileRequest;
import com.example.demo.domain.model.RegistrationProfileResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ApiTransactionPersistenceAdapterTest {
    private ApiTransactionRepository repository;
    private ObjectMapper objectMapper;
    private ApiTransactionPersistenceAdapter adapter;

    @BeforeEach
    void setUp() {
        repository = mock(ApiTransactionRepository.class);
        objectMapper = mock(ObjectMapper.class);
        adapter = new ApiTransactionPersistenceAdapter(repository, objectMapper);
    }

    @Test
    void saveTransaction_success() throws Exception {
        RegistrationProfileRequest request = RegistrationProfileRequest.builder()
                .refId("C00011").firstName("John").lastName("Doe").hkid("A1234567")
                .passportNo("P1234567").gender("male").contactNo("85288888888")
                .dob("1990-01-01").email("john.doe@example.com").optIn("yes").build();
        RegistrationProfileResponse data = new RegistrationProfileResponse("pid", "pending");
        ApiResponse<RegistrationProfileResponse> response = new ApiResponse<>(0, "success", data);
        when(objectMapper.writeValueAsString(any())).thenReturn("{}", "{}");
        adapter.saveTransaction("pid", request, response, "pending");
        verify(repository, times(1)).save(any(ApiTransactionEntity.class));
    }

    @Test
    void saveTransaction_objectMapperThrows_exceptionThrown() throws Exception {
        RegistrationProfileRequest request = RegistrationProfileRequest.builder()
                .refId("C00011").firstName("John").lastName("Doe").hkid("A1234567")
                .passportNo("P1234567").gender("male").contactNo("85288888888")
                .dob("1990-01-01").email("john.doe@example.com").optIn("yes").build();
        RegistrationProfileResponse data = new RegistrationProfileResponse("pid", "pending");
        ApiResponse<RegistrationProfileResponse> response = new ApiResponse<>(0, "success", data);
        when(objectMapper.writeValueAsString(any())).thenThrow(new RuntimeException("JSON error"));
        assertThrows(RuntimeException.class, () -> adapter.saveTransaction("pid", request, response, "pending"));
        verify(repository, never()).save(any());
    }
} 