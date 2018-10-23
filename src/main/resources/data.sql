insert into USERS (username, password, enabled, role) values ('admin', 'admin', true, 'ROLE_ADMIN');
insert into USERS (username, password, enabled, role) values ('username', 'password', true, 'ROLE_USER');

insert into RECIPES (name, created_at, updated_at) values ('recept1', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
insert into RECIPES (name, created_at, updated_at) values ('recept2', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
insert into RECIPES (name, created_at, updated_at) values ('recept3', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
insert into RECIPES (name, created_at, updated_at) values ('recept4', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());

