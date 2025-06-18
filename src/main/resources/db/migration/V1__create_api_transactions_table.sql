CREATE TABLE api_transactions (
    id SERIAL PRIMARY KEY,
    process_id VARCHAR(255) NOT NULL,
    req_payload JSONB NOT NULL,
    res_payload JSONB,
    status VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
); 