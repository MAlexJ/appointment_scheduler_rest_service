ALTER TABLE events
    ADD CONSTRAINT client_id_fk
        FOREIGN KEY (client_id) REFERENCES clients (id);