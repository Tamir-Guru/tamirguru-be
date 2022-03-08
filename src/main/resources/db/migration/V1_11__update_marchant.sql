ALTER TABLE merchants
    ADD COLUMN email VARCHAR(255);

ALTER TABLE merchants
    ADD COLUMN website VARCHAR(255);

ALTER TABLE merchants
    ADD COLUMN approved boolean not null default false;