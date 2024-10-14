INSERT INTO roles (id_role, name) VALUES (default, 'ROLE_USER');
INSERT INTO roles (id_role, name) VALUES (default, 'ROLE_ADMIN');
INSERT INTO roles (id_role, name) VALUES (default, 'ROLE_SALESMAN');
/* Users */
INSERT INTO users (id_user, username, password, password_changed)
VALUES (default, 'tito@gmail.com', '$2a$12$dA70.eW4pS9xXcJsws6MsO2w6fq4/pOEfPyplrI/izLxQo1KsIL2C', false);
INSERT INTO users (id_user, username, password, password_changed)
VALUES (default, 'pepa@gmail.com', '$2a$12$fw8qjZwWYhvR.xzLUN5LuejC03NqCFuJQYwnstpBWki.Yi4L64MkW', false);
INSERT INTO users (id_user, username, password, password_changed)
VALUES (default, 'bob@gmail.com', '$2a$12$7uWA52eNAmqdmIN5mq01iuFR2o8rpfDzrQQ.H4NOmENrILiAvMysC', false);
INSERT INTO users (id_user, username, password, password_changed)
VALUES (default, 'lolo@gmail.com', '$2a$12$FjUhJEtSs86qmVt/kas07e0MO4/jNCxixw63m.vSBRHL.Tg0Ybify', false);
/* Assign roles to users */
INSERT INTO roles_users (role_id, user_id) VALUES (1, 1);
INSERT INTO roles_users (role_id, user_id) VALUES (2, 2);
INSERT INTO roles_users (role_id, user_id) VALUES (3, 3);
INSERT INTO roles_users (role_id, user_id) VALUES (3, 4);
 



INSERT INTO zone (name) VALUES ('Área de Avilés');
INSERT INTO zone (name) VALUES ('Área de Gijón');
INSERT INTO zone (name) VALUES ('Área de Oviedo');
INSERT INTO zone (name) VALUES ('Caudal');
INSERT INTO zone (name) VALUES ('Eo-Navia');
INSERT INTO zone (name) VALUES ('Nalón');
INSERT INTO zone (name) VALUES ('Narcea');
INSERT INTO zone (name) VALUES ('Oriente'); 



INSERT INTO Property (price, description, address, area, action, property_type, room, bathroom, has_elevator, floors, user_id)
VALUES 
(150000, 'Hermoso apartamento con vista al mar.', 'Calle del Mar 123, Gijón', 85.0, 'venta', 'FLAT', 2, 1, true, 5, 3),
(1200, 'Piso céntrico en alquiler, bien comunicado.', 'Plaza Mayor 789, Avilés', 60.0, 'alquiler', 'FLAT', 1, 1, false, 1, 3),
(180000, 'Moderno apartamento en la ciudad.', 'Avenida de la Libertad 45, Oviedo', 75.0, 'venta', 'FLAT', 2, 2, true, 3, 3),
(900, 'Acogedor piso en el barrio antiguo.', 'Calle de la Historia 34, Gijón', 50.0, 'alquiler', 'FLAT', 1, 1, false, 2, 3),
(250000, 'Amplio apartamento con balcón.', 'Calle del Sol 12, Avilés', 90.0, 'venta', 'FLAT', 3, 2, true, 4, 3);

INSERT INTO Property (price, description, address, area, action, property_type, room, bathroom, floors, user_id)
VALUES 
(250000, 'Casa espaciosa con jardín y piscina.', 'Calle del Jardín 10, Gijón', 150.0, 'venta', 'HOUSE', 4, 2, 2, 3),
(180000, 'Acogedora casa en una zona tranquila.', 'Calle de la Paz 45, Avilés', 120.0, 'venta', 'HOUSE', 3, 1, 1, 3),
(1500, 'Casa en alquiler, ideal para familias.', 'Avenida de la Familia 22, Oviedo', 110.0, 'alquiler', 'HOUSE', 3, 2, 1, 3),
(320000, 'Casa moderna con todas las comodidades.', 'Calle Nueva 5, Gijón', 200.0, 'venta', 'HOUSE', 5, 3, 2, 3),
(1200, 'Casa en alquiler cerca de la playa.', 'Calle del Sol 20, Avilés', 90.0, 'alquiler', 'HOUSE', 2, 1, 1, 3);

INSERT INTO Property (price, description, address, area, action, property_type, user_id)
VALUES 
(50000, 'Trastero amplio en el centro de la ciudad.', 'Calle de la Almacen 1, Gijón', 20.0, 'venta', 'STORAGEROOM', 3),
(400, 'Pequeño trastero ideal para guardar bicicletas.', 'Calle del Garaje 10, Avilés', 10.0, 'alquiler', 'STORAGEROOM', 3),
(60000, 'Trastero con acceso fácil y seguro.', 'Avenida de la Organización 15, Oviedo', 25.0, 'venta', 'STORAGEROOM', 3),
(300, 'Trastero en alquiler en zona residencial.', 'Calle del Almacenamiento 5, Gijón', 15.0, 'alquiler', 'STORAGEROOM', 3),
(70000, 'Gran trastero con sistema de seguridad.', 'Calle del Resguardo 3, Avilés', 30.0, 'venta', 'STORAGEROOM', 3);

INSERT INTO Property (price, description, address, area, action, property_type, user_id)
VALUES 
(20000, 'Garaje cerrado en el centro de la ciudad.', 'Calle de la Estacion 5, Gijón', 18.0, 'venta', 'GARAGE', 3),
(150, 'Plaza de garaje en alquiler, fácil acceso.', 'Calle de la Libertad 8, Avilés', 12.0, 'alquiler', 'GARAGE', 3),
(25000, 'Garaje amplio con espacio para dos coches.', 'Avenida de la Paz 20, Oviedo', 25.0, 'venta', 'GARAGE', 3),
(100, 'Garaje en alquiler en zona tranquila.', 'Calle del Automóvil 7, Gijón', 15.0, 'alquiler', 'GARAGE', 3),
(30000, 'Garaje en venta con seguridad las 24 horas.', 'Calle de la Seguridad 9, Avilés', 20.0, 'venta', 'GARAGE', 3);

INSERT INTO appointments (id, name, phone, time_slot, property_id) VALUES
(default, 'Luis Ramírez', '654321987', '9:00-12:00', 1),
(default, 'María López', '678543210', '12:00-14:00', 5),
(default, 'Juan García', '612345678', '16:00-18:00', 6),
(default, 'Ana Fernández', '687654321', '18:00-20:00', 10),
(default, 'Pedro Sánchez', '623456789', '9:00-12:00', 15);


