DROP SCHEMA IF EXISTS threed;

CREATE SCHEMA threed;

CREATE TABLE threed.category
(
    id         BIGSERIAL PRIMARY KEY,
    name       VARCHAR(255) NOT NULL,
    created_at TIMESTAMP    NOT NULL,
    updated_at TIMESTAMP
);


CREATE TABLE threed.product
(
    id          BIGSERIAL PRIMARY KEY,
    created_at  TIMESTAMP        NOT NULL,
    updated_at  TIMESTAMP,
    name        VARCHAR(255)     NOT NULL,
    code        VARCHAR(255)     NOT NULL,
    description VARCHAR(600)     NOT NULL,
    image_name  VARCHAR(255),
    price       DOUBLE PRECISION NOT NULL,
    quantity    BIGINT           NOT NULL,
    category_id BIGINT           NOT NULL,
    FOREIGN KEY (category_id) REFERENCES threed.category (id)
);

CREATE TABLE threed.user
(
    id         BIGSERIAL PRIMARY KEY,
    user_name  VARCHAR(255) UNIQUE NOT NULL,
    password   VARCHAR(255)        NOT NULL,
    enabled    BOOLEAN             NOT NULL DEFAULT true,
    created_at TIMESTAMP           NOT NULL,
    updated_at TIMESTAMP
);

CREATE TABLE threed.user_roles
(
    id        BIGSERIAL PRIMARY KEY,
    user_name VARCHAR(255) NOT NULL,
    role_name VARCHAR(50)  NOT NULL,
    FOREIGN KEY (user_name) REFERENCES threed.user (user_name)
);

CREATE TABLE threed.cart
(
    id         BIGSERIAL PRIMARY KEY,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP
);

CREATE TABLE threed.cart_item
(
    id         BIGSERIAL PRIMARY KEY,
    quantity   BIGINT    NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP,
    cart_id    BIGINT    NOT NULL,
    product_id BIGINT    NOT NULL,
    FOREIGN KEY (product_id) REFERENCES threed.product (id),
    FOREIGN KEY (cart_id) REFERENCES threed.cart (id)
)
