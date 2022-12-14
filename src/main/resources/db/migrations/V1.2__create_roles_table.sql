CREATE TABLE roles (
  id BIGINT NOT NULL,
   name VARCHAR(255) NOT NULL,
   slug VARCHAR(255) NOT NULL,
   user_id BIGINT,
   CONSTRAINT pk_roles PRIMARY KEY (id)
);

ALTER TABLE roles ADD CONSTRAINT FK_ROLES_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);