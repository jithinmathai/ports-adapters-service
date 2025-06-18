package com.example.demo.api;

import com.example.demo.application.RegistrationProfileService;
import com.example.demo.domain.model.RegistrationProfileRequest;
import com.example.demo.domain.model.RegistrationProfileResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RegistrationProfileController.class)
class RegistrationProfileControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private RegistrationProfileService registrationProfileService;

    @Test
    void registerProfile_success() throws Exception {
        RegistrationProfileRequest request = RegistrationProfileRequest.builder()
                .refId("C00011").firstName("John").lastName("Doe").hkid("A1234567")
                .passportNo("P1234567").gender("male").contactNo("85288888888")
                .dob("1990-01-01").email("john.doe@example.com").optIn("yes").build();
        RegistrationProfileResponse.Data data = new RegistrationProfileResponse.Data("process-1", "pending");
        RegistrationProfileResponse response = new RegistrationProfileResponse(0, "success", data);
        Mockito.when(registrationProfileService.registerProfile(any())).thenReturn(response);
        mockMvc.perform(post("/api/v1/registration/profile")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(0))
                .andExpect(jsonPath("$.msg").value("success"))
                .andExpect(jsonPath("$.data.process_id").value("process-1"));
    }

    @Test
    void registerProfile_invalidRequest_returnsBadRequest() throws Exception {
        String invalidJson = "{";
        mockMvc.perform(post("/api/v1/registration/profile")
                .contentType(MediaType.APPLICATION_JSON)
                .content(invalidJson))
                .andExpect(status().isBadRequest());
    }
} 