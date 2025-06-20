package com.example.demo.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DomainModelTest {
    @Test
    void testApiTransactionRecord() {
        ApiTransaction tx = ApiTransaction.builder()
            .id(1L)
            .processId("pid")
            .reqPayload("{}")
            .resPayload("{}")
            .status("pending")
            .createdAt(null)
            .updatedAt(null)
            .build();
        assertEquals("pid", tx.getProcessId());
    }

    @Test
    void testRegistrationProfileRequestRecord() {
        RegistrationProfileRequest req = RegistrationProfileRequest.builder()
            .refId("C00011").firstName("John").lastName("Doe").hkid("A1234567")
            .passportNo("P1234567").gender("male").contactNo("85288888888")
            .dob("1990-01-01").email("john.doe@example.com").optIn("yes").build();
        assertEquals("John", req.getFirstName());
    }

    @Test
    void testRegistrationProfileResponseRecord() {
        RegistrationProfileResponse res = new RegistrationProfileResponse("pid", "pending");
        assertEquals("pid", res.getProcessId());
    }

    @Test
    void testApiResponse() {
        RegistrationProfileResponse res = new RegistrationProfileResponse("pid", "pending");
        ApiResponse<RegistrationProfileResponse> apiResponse = new ApiResponse<>(0, "success", res);
        assertEquals(0, apiResponse.getCode());
        assertEquals("success", apiResponse.getMsg());
        assertEquals("pid", apiResponse.getData().getProcessId());
    }
} 