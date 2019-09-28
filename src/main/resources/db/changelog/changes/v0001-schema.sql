DROP SCHEMA IF EXISTS threed;

CREATE SCHEMA threed;

CREATE TABLE threed.product
(
    id          BIGSERIAL PRIMARY KEY,
    created_at  TIMESTAMP        NOT NULL,
    updated_at  TIMESTAMP,
    code        VARCHAR(255)     NOT NULL,
    description VARCHAR(255)     NOT NULL,
    image       BYTEA,
    price       DOUBLE PRECISION NOT NULL,
    quantity    BIGINT           NOT NULL,
    category_id BIGINT           NOT NULL
);

CREATE TABLE threed.user
(
    id         BIGSERIAL PRIMARY KEY,
    created_at TIMESTAMP           NOT NULL,
    updated_at TIMESTAMP,
    username   VARCHAR(255) UNIQUE NOT NULL,
    password   VARCHAR(255)        NOT NULL,
    enabled    BOOLEAN             NOT NULL DEFAULT true
);

CREATE TABLE threed.user_roles
(
    id       BIGSERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    role     VARCHAR(50)  NOT NULL,
    FOREIGN KEY (username) REFERENCES threed.user (username)
)
