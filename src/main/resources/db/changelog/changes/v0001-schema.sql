DROP SCHEMA IF EXISTS threed;

CREATE SCHEMA threed;

create table threed.product
(
    id          BIGSERIAL PRIMARY KEY,
    created_at   TIMESTAMP,
    updated_at   TIMESTAMP,
    code        VARCHAR(255)     NOT NULL,
    description VARCHAR(255)     NOT NULL,
    image       BYTEA,
    price       DOUBLE PRECISION NOT NULL,
    quantity    BIGINT           NOT NULL,
    category_id  BIGINT NOT NULL
);