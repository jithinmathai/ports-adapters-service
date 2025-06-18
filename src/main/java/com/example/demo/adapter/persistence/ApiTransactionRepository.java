package com.example.demo.adapter.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiTransactionRepository extends JpaRepository<ApiTransactionEntity, Long> {
} 