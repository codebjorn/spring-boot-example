
-- Add admin user --
INSERT INTO "public"."users" ("id", "name", "username", "email", "password")
VALUES ('1', 'Admin', 'admin', 'admin@test.com', '$argon2id$v=19$m=4096,t=3,p=1$Xhxti9xKn2B1MnfPJp7zzA$5sxfHo9PO4S0Q3xINFbvhwwfX7qlW2S0jL7a7eq+5/Y');

-- Add admin role --
INSERT INTO "public"."roles" ("id", "name", "slug", "user_id")
VALUES ('1', 'Admin', 'admin', '1') ;

-- Add admin workspace --
INSERT INTO "public"."workspaces" ("id", "name", "slug", "user_id")
VALUES ('1', 'Admin Workspace', 'admin-workspace', '1');

-- Add admin project --
INSERT INTO "public"."projects" ("id", "name", "slug", "description")
VALUES ('1', 'Admin Project', 'admin-project', 'This is admin project');