package com.example.demo.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DomainModelTest {
    @Test
    void testApiTransactionRecord() {
        ApiTransaction tx = new ApiTransaction(1L, "pid", "{}", "{}", "pending", null, null);
        assertEquals("pid", tx.processId());
    }

    @Test
    void testRegistrationProfileRequestRecord() {
        RegistrationProfileRequest req = RegistrationProfileRequest.builder()
            .ref_id("C00011").first_name("John").last_name("Doe").hkid("A1234567")
            .passport_no("P1234567").gender("male").contact_no("85288888888")
            .DOB("1990-01-01").email("john.doe@example.com").opt_in("yes").build();
        assertEquals("John", req.first_name());
    }

    @Test
    void testRegistrationProfileResponseRecord() {
        RegistrationProfileResponse.Data data = new RegistrationProfileResponse.Data("pid", "pending");
        RegistrationProfileResponse res = new RegistrationProfileResponse(0, "success", data);
        assertEquals("success", res.msg());
    }
} 