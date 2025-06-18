package com.example.demo.application;

import com.example.demo.domain.model.RegistrationProfileRequest;
import com.example.demo.domain.model.RegistrationProfileResponse;
import com.example.demo.domain.port.ApiTransactionPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class RegistrationProfileServiceImplTest {
    private ApiTransactionPort apiTransactionPort;
    private RegistrationProfileServiceImpl service;

    @BeforeEach
    void setUp() {
        apiTransactionPort = mock(ApiTransactionPort.class);
        service = new RegistrationProfileServiceImpl(apiTransactionPort);
    }

    @Test
    void registerProfile_success() {
        RegistrationProfileRequest request = RegistrationProfileRequest.builder()
                .ref_id("C00011").first_name("John").last_name("Doe").hkid("A1234567")
                .passport_no("P1234567").gender("male").contact_no("85288888888")
                .DOB("1990-01-01").email("john.doe@example.com").opt_in("yes").build();
        RegistrationProfileResponse response = service.registerProfile(request);
        assertEquals(0, response.code());
        assertEquals("success", response.msg());
        assertNotNull(response.data());
        assertEquals("pending", response.data().status());
        verify(apiTransactionPort, times(1)).saveTransaction(any(), any(), any(), any());
    }

    @Test
    void registerProfile_nullRequest_throwsException() {
        assertThrows(NullPointerException.class, () -> service.registerProfile(null));
    }
} 