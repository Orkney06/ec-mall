CREATE TABLE users (
    id VARCHAR(36) PRIMARY KEY,
    membership_id VARCHAR(255) UNIQUE NOT NULL,
    account_status VARCHAR(50) NOT NULL DEFAULT 'active',
    registration_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_login TIMESTAMP,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);