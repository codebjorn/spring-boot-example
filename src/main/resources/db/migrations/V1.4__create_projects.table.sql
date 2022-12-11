CREATE TABLE projects (
  id BIGINT NOT NULL,
   name VARCHAR(255) NOT NULL,
   slug VARCHAR(255) NOT NULL,
   description VARCHAR(255),
   CONSTRAINT pk_projects PRIMARY KEY (id)
);