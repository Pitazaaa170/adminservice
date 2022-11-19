--liquibase formatted sql

--changeset asvladimirov:1
CREATE TABLE user_registrations (
    id BIGINT PRIMARY KEY ,
    name VARCHAR(32) NOT NULL,
    surname VARCHAR(32) NOT NULL,
    role VARCHAR(32) NOT NULL,
    is_registered BOOLEAN NOT NULL,
    is_blocked BOOLEAN NOT NULL DEFAULT FALSE
)