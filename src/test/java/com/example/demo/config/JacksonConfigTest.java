package com.example.demo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class JacksonConfigTest {
    @Autowired
    ObjectMapper objectMapper;

    @Test
    void contextLoads() {
        assertNotNull(objectMapper);
    }
} 