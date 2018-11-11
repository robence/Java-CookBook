insert into USERS (username, password, enabled, role) values ('admin', 'admin', true, 'ROLE_ADMIN');
insert into USERS (username, password, enabled, role) values ('user1', 'user1', true, 'ROLE_USER');
insert into USERS (username, password, enabled, role) values ('user2', 'user2', true, 'ROLE_USER');

insert into RECIPES (name, created_at, updated_at) values ('recept1', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
insert into RECIPES (name, created_at, updated_at) values ('recept2', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
insert into RECIPES (name, created_at, updated_at) values ('recept3', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
insert into RECIPES (name, created_at, updated_at) values ('recept4', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());

insert into INGREDIENTS (name) values ('krumpli');
insert into INGREDIENTS (name) values ('salata');
insert into INGREDIENTS (name) values ('repa');
insert into INGREDIENTS (name) values ('karalabe');