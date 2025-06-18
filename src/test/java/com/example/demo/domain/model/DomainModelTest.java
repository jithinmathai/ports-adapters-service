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
        RegistrationProfileResponse.Data data = new RegistrationProfileResponse.Data("pid", "pending");
        RegistrationProfileResponse res = new RegistrationProfileResponse(0, "success", data);
        assertEquals("success", res.getMsg());
    }
} 