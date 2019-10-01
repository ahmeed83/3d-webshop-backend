INSERT INTO threed.category(name, created_at, updated_at)
VALUES ('Computers', current_timestamp, null);
INSERT INTO threed.category(name, created_at, updated_at)
VALUES ('Laptops', current_timestamp, null);
INSERT INTO threed.category(name, created_at, updated_at)
VALUES ('Mobile telefoons', current_timestamp, null);
INSERT INTO threed.category(name, created_at, updated_at)
VALUES ('Computer tools', current_timestamp, null);
INSERT INTO threed.category(name, created_at, updated_at)
VALUES ('Moniters', current_timestamp, null);


INSERT INTO threed.product(name, code, description, price, quantity, category_id, created_at, updated_at)
VALUES ('Macbook 15', '54567654', 'Macbook 15', 315, 15, 1, current_timestamp, null);

INSERT INTO threed.product(name, code, description, price, quantity, category_id, created_at, updated_at)
VALUES ('DELL', '1223243', 'DELL', 200, 15, 1, current_timestamp, null);

INSERT INTO threed.product(name, code, description, price, quantity, category_id, created_at, updated_at)
VALUES ('IPHONE 11', '098433232', 'IPHONE 11', 700, 90, 3, current_timestamp, null);

INSERT INTO threed.product(name, code, description, price, quantity, category_id, created_at, updated_at)
VALUES ('GALAXY 9', '2T656754', 'GALAXY 9', 200, 150, 3, current_timestamp, null);

INSERT INTO threed.product(name, code, description, price, quantity, category_id, created_at, updated_at)
VALUES ('LENOVO', '23R565675', 'LENOVO', 300, 20, 1, current_timestamp, null);

INSERT INTO threed.product(name, code, description, price, quantity, category_id, created_at, updated_at)
VALUES ('HP', '4627SDJHSD', 'HP', 2300, 90, 1, current_timestamp, null);

INSERT INTO threed.user(user_name, password, enabled, created_at)
VALUES ('hayder@gmail.com', '123', true, current_timestamp);
INSERT INTO threed.user(user_name, password, enabled, created_at)
VALUES ('ahmed@gmail.com', '123', true, current_timestamp);

INSERT INTO threed.user_roles (user_name, role_name)
VALUES ('hayder@gmail.com', 'ROLE_USER');
INSERT INTO threed.user_roles (user_name, role_name)
VALUES ('hayder@gmail.com', 'ROLE_ADMIN');
INSERT INTO threed.user_roles (user_name, role_name)
VALUES ('ahmed@gmail.com', 'ROLE_USER');

INSERT INTO threed.cart(created_at)
VALUES (current_timestamp);