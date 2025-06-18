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
                .refId("C00011").firstName("John").lastName("Doe").hkid("A1234567")
                .passportNo("P1234567").gender("male").contactNo("85288888888")
                .dob("1990-01-01").email("john.doe@example.com").optIn("yes").build();
        RegistrationProfileResponse response = service.registerProfile(request);
        assertEquals(0, response.getCode());
        assertEquals("success", response.getMsg());
        assertNotNull(response.getData());
        assertEquals("pending", response.getData().getStatus());
        verify(apiTransactionPort, times(1)).saveTransaction(any(), any(), any(), any());
    }

    @Test
    void registerProfile_nullRequest_throwsException() {
        assertThrows(NullPointerException.class, () -> service.registerProfile(null));
    }
} 