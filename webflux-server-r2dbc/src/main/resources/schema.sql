CREATE SCHEMA IF NOT EXISTS webflux;

CREATE TABLE IF NOT EXISTS person(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255)
);