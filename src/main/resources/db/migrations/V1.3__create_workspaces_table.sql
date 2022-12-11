CREATE TABLE workspaces (
  id BIGINT NOT NULL,
   name VARCHAR(255) NOT NULL,
   slug VARCHAR(255) NOT NULL,
   user_id BIGINT,
   CONSTRAINT pk_workspaces PRIMARY KEY (id)
);