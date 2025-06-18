package com.example.demo.adapter.persistence;

import com.example.demo.domain.model.ApiTransaction;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ApiTransactionMapper {
    ApiTransaction toDomain(ApiTransactionEntity entity);
    ApiTransactionEntity toEntity(ApiTransaction domain);
} 