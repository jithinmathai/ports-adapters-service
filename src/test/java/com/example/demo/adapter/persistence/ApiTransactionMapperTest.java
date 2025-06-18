package com.example.demo.adapter.persistence;

import com.example.demo.domain.model.ApiTransaction;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ApiTransactionMapperTest {
    private final ApiTransactionMapper mapper = Mappers.getMapper(ApiTransactionMapper.class);

    @Test
    void testEntityToDomainAndBack() {
        ApiTransactionEntity entity = ApiTransactionEntity.builder()
            .id(1L)
            .processId("pid")
            .reqPayload("{}")
            .resPayload("{}")
            .status("pending")
            .createdAt(LocalDateTime.now())
            .updatedAt(LocalDateTime.now())
            .build();

        ApiTransaction domain = mapper.toDomain(entity);
        assertEquals(entity.getProcessId(), domain.processId());
        assertEquals(entity.getStatus(), domain.status());

        ApiTransactionEntity entity2 = mapper.toEntity(domain);
        assertEquals(entity.getProcessId(), entity2.getProcessId());
        assertEquals(entity.getStatus(), entity2.getStatus());
    }
} 