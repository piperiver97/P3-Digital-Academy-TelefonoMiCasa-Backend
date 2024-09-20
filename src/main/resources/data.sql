 /* Roles */
INSERT INTO roles (id_role, name) VALUES (default, 'ROLE_USER');
INSERT INTO roles (id_role, name) VALUES (default, 'ROLE_ADMIN');
INSERT INTO roles (id_role, name) VALUES (default, 'ROLE_SALESMAN');

/* Users */
INSERT INTO users (id_user, username, password) VALUES (default, 'pepe', '1234');
INSERT INTO users (id_user, username, password) VALUES (default, 'pepa', '$2a$12$fw8qjZwWYhvR.xzLUN5LuejC03NqCFuJQYwnstpBWki.Yi4L64MkW');
INSERT INTO users (id_user, username, password) VALUES (default, 'bob', '$2a$12$ZqgJ/F3td45dqWFH4rg.Ruwpf9Ai8Jvd1XfG/TkhVAEn611u1Iruy');

INSERT INTO roles_users (role_id, user_id) VALUES (1, 1);
INSERT INTO roles_users (role_id, user_id) VALUES (2, 2); 
INSERT INTO roles_users (role_id, user_id) VALUES (3, 3); 

-- Insertar algunos datos de ejemplo en la tabla 'properti'
INSERT INTO properti (price, description, address, area, action) VALUES
(150000.00, 'Hermoso apartamento con vista al mar.', 'Calle del Mar 123, Gijón', 85.0, 'venta'),
(200000.00, 'Casa espaciosa con jardín y piscina.', 'Avenida del Sol 456, Oviedo', 150.0, 'venta'),
(1200.00, 'Piso céntrico en alquiler, bien comunicado.', 'Plaza Mayor 789, Avilés', 60.0, 'alquiler'),
(350000.00, 'Ático con terraza y vistas panorámicas.', 'Calle de la Luna 321, Llanes', 100.0, 'venta');