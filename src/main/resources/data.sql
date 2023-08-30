
-- Tenant Customers
--- Tenant Customer
INSERT INTO customer (id,created_at,updated_at,deleted_at, code, name, description,active)
    SELECT '01006269-3279-461d-b2f5-f68c5aab7c93', '2022-10-10 10:49:18.609', '2022-10-10 10:49:18.609', NULL, 0, 'Admin', 'Administration', true
    WHERE
        NOT EXISTS (
                SELECT id FROM customer WHERE id =  '01006269-3279-461d-b2f5-f68c5aab7c93'
            );

--- Tenant Customer 01
INSERT INTO customer (id,created_at,updated_at,deleted_at, code, name, description,active)
    SELECT '01016269-3279-461d-b2f5-f68c5aab7c93', '2022-10-10 10:49:18.609', '2022-10-10 10:49:18.609', NULL, 1, 'Customer 01', 'Customer 01 Services', true
    WHERE
        NOT EXISTS (
                SELECT id FROM customer WHERE id =  '01016269-3279-461d-b2f5-f68c5aab7c93'
            );

--- Tenant Customer 03
INSERT INTO customer (id,created_at,updated_at,deleted_at, code, name, description,active)
    SELECT '01026269-3279-461d-b2f5-f68c5aab7c93', '2022-10-10 10:49:18.609', '2022-10-10 10:49:18.609', NULL, 2, 'Customer 02', 'Customer 02 Conectividade', true
    WHERE
        NOT EXISTS (
                SELECT id FROM customer WHERE id =  '01026269-3279-461d-b2f5-f68c5aab7c93'
            );

-------------------------------------------------------------------------------------------------------------------

-- User roles
--- Role User
INSERT INTO role(id, created_at,updated_at,deleted_at, name)
    SELECT '00006269-3279-461d-b2f5-f68c5aab7c93', '2022-10-10 10:49:18.609', '2022-10-10 10:49:18.609', NULL, 'ROLE_USER'
    WHERE
        NOT EXISTS (
                SELECT id FROM customer WHERE id = '00006269-3279-461d-b2f5-f68c5aab7c93'
        );

-- Role moderator
INSERT INTO role(id, created_at,updated_at,deleted_at, name)
    SELECT '00016269-3279-461d-b2f5-f68c5aab7c93', '2022-10-10 10:49:18.609', '2022-10-10 10:49:18.609', NULL, 'ROLE_MODERATOR'
    WHERE
        NOT EXISTS (
                SELECT id FROM customer WHERE id = '00016269-3279-461d-b2f5-f68c5aab7c93'
        );

-- Role Admin
INSERT INTO role(id, created_at,updated_at,deleted_at, name)
    SELECT '00026269-3279-461d-b2f5-f68c5aab7c93', '2022-10-10 10:49:18.609', '2022-10-10 10:49:18.609', NULL, 'ROLE_ADMIN'
    WHERE
        NOT EXISTS (
                SELECT id FROM customer WHERE id = '00026269-3279-461d-b2f5-f68c5aab7c93'
        );
-------------------------------------------------------------------------------------------------------------------

-- User clients
--- User admin
INSERT INTO users(id, created_at,updated_at,deleted_at, username, email, password, customer_id)
    SELECT '11116269-3279-461d-b2f5-f68c5aab7c93', '2022-10-10 10:49:18.609', '2022-10-10 10:49:18.609', NULL, 'admin', 'admin@mail.com', '$2a$12$luu9yI6tZAPV9lO0PkwHx.HBV/fCEfJGoc8XT4PvRGYZ7eXY.pFPu', '01006269-3279-461d-b2f5-f68c5aab7c93'
    WHERE
        NOT EXISTS (
                SELECT id FROM customer WHERE id = '11116269-3279-461d-b2f5-f68c5aab7c93'
        );

--- User Client
INSERT INTO users(id, created_at,updated_at,deleted_at, username, email, password, customer_id)
    SELECT '11126269-3279-461d-b2f5-f68c5aab7c93', '2022-10-10 10:49:18.609', '2022-10-10 10:49:18.609', NULL, 'client01', 'client01@mail.com', '$2a$12$hF8WFt0qq4hW9QlWzeev7..yaT92.wQYajaS99lkUmQNs3UhJ.f0a',  '01016269-3279-461d-b2f5-f68c5aab7c93'
    WHERE
        NOT EXISTS (
                SELECT id FROM customer WHERE id = '11126269-3279-461d-b2f5-f68c5aab7c93'
        );

-- Association User-Roles
--- (user admin, role admin)
INSERT INTO user_roles(user_id, role_id) VALUES ('11116269-3279-461d-b2f5-f68c5aab7c93', '00026269-3279-461d-b2f5-f68c5aab7c93');

--- (user client, role user)
INSERT INTO user_roles(user_id, role_id) VALUES ('11126269-3279-461d-b2f5-f68c5aab7c93', '00006269-3279-461d-b2f5-f68c5aab7c93');

-------------------------------------------------------------------------------------------------------------------

-- Products
--- Product Smartphone Samsung s20
INSERT INTO product (id,created_at, updated_at, deleted_at,name,description,product_type,active)
    SELECT '02016269-3279-461d-b2f5-f68c5aab7c93', '2022-10-10 10:49:18.609', '2022-10-10 10:49:18.609', NULL,'Smartphone Samsung S20','Smartphone Galaxy S20 128GB','Mobilidade',true
    WHERE
        NOT EXISTS (
                SELECT id FROM product WHERE id = '02016269-3279-461d-b2f5-f68c5aab7c93'
            );

--- Product Smartphone Iphone 12
INSERT INTO product (id,created_at, updated_at, deleted_at,name,description,product_type,active)
    SELECT '02026269-3279-461d-b2f5-f68c5aab7c93', '2022-10-10 10:49:18.609', '2022-10-10 10:49:18.609', NULL,'Smartphone IPhone 12','Smartphone IPhone 12 5G','Mobilidade',true
    WHERE
        NOT EXISTS (
                SELECT id FROM product WHERE id = '02026269-3279-461d-b2f5-f68c5aab7c93'
            );

-------------------------------------------------------------------------------------------------------------------

-- Association Customers-Products
--- (Client 01, Samsung S20)
INSERT INTO customer_product (id,created_at, updated_at, deleted_at, price, customer_id, product_id)
    SELECT '03016269-3279-461d-b2f5-f68c5aab7c93', '2022-10-10 10:49:18.609', '2022-10-10 10:49:18.609', NULL, 2000, '01016269-3279-461d-b2f5-f68c5aab7c93', '02016269-3279-461d-b2f5-f68c5aab7c93'
    WHERE
        NOT EXISTS (
                SELECT id FROM customer_product WHERE id = '03016269-3279-461d-b2f5-f68c5aab7c93'
            );

--- (Client 01, Iphone 12)
INSERT INTO customer_product (id,created_at, updated_at, deleted_at, price, customer_id, product_id)
    SELECT '03026269-3279-461d-b2f5-f68c5aab7c93', '2022-10-10 10:49:18.609', '2022-10-10 10:49:18.609', NULL, 3000, '01016269-3279-461d-b2f5-f68c5aab7c93', '02026269-3279-461d-b2f5-f68c5aab7c93'
    WHERE
        NOT EXISTS (
                SELECT id FROM customer_product WHERE id = '03026269-3279-461d-b2f5-f68c5aab7c93'
            );

--- (Client 02, Samsung S20)
INSERT INTO customer_product (id,created_at, updated_at, deleted_at, price, customer_id, product_id)
    SELECT '03036269-3279-461d-b2f5-f68c5aab7c93', '2022-10-10 10:49:18.609', '2022-10-10 10:49:18.609', NULL, 2500, '01026269-3279-461d-b2f5-f68c5aab7c93', '02016269-3279-461d-b2f5-f68c5aab7c93'
    WHERE
        NOT EXISTS (
                SELECT id FROM customer_product WHERE id = '03036269-3279-461d-b2f5-f68c5aab7c93'
            );
