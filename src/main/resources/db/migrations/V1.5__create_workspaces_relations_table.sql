CREATE TABLE workspaces_projects (
  workspace_id BIGINT NOT NULL,
   project_id BIGINT NOT NULL
);

ALTER TABLE workspaces_projects ADD CONSTRAINT uc_workspaces_projects_projects UNIQUE (project_id);

ALTER TABLE workspaces ADD CONSTRAINT FK_WORKSPACES_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);

ALTER TABLE workspaces_projects ADD CONSTRAINT fk_worpro_on_project FOREIGN KEY (project_id) REFERENCES projects (id);

ALTER TABLE workspaces_projects ADD CONSTRAINT fk_worpro_on_workspace FOREIGN KEY (workspace_id) REFERENCES workspaces (id);