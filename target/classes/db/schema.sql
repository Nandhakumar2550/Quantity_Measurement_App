CREATE TABLE IF NOT EXISTS quantity_measurements (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    operation VARCHAR(100),
    measurement_type VARCHAR(100),
    value1 DOUBLE,
    value2 DOUBLE,
    result VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
