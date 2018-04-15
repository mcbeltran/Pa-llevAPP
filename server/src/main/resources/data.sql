insert into university ( id, name, domain ) values ( 1, 'Javeriana', '@javeriana.edu.co' );
insert into university ( id, name, domain ) values ( 2, 'Nacional', '@unal.edu.co' );
insert into university ( id, name, domain ) values ( 3, 'Antioquia', '@udea.edu.co' );

insert into registered_user ( id, username, password, name, lastname, role, institution_id ) values ( 1, 'CamiV', '123', 'Camila', 'Villarreal', 0, 1 );
insert into registered_user ( id, username, password, name, lastname, role, institution_id ) values ( 2, 'CamiB', '123', 'Camila', 'Beltran', 0, 2 );
insert into registered_user ( id, username, password, name, lastname, role, institution_id ) values ( 3, 'Yisus', '123', 'Jesus', 'Pineda', 0, 3 );

insert into offer ( id, product_name, inventory, price, description, image_url, univendedor_id, branch_id, category ) values ( 1, 'Gomitas', 100, 200, 'Ricas gomitas con forma de tortuga y relleno liquido', '-', 1, 1, 'Dulce' );
insert into offer ( id, product_name, inventory, price, description, image_url, univendedor_id, branch_id, category ) values ( 2, 'Ensalada chevere', 17, 10000, 'Deliciosas ensaladas asiaticas', '-', 1, 1, 'Almuerzo' );
insert into offer ( id, product_name, inventory, price, description, image_url, univendedor_id, branch_id, category ) values ( 3, 'Cigarrillos de dulce', 100, 100, 'Deliciosas colaciones en forma de cigarrillo de diferentes sabores', '-', 2, 2, 'Dulce' );