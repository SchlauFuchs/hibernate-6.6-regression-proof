INSERT INTO users (id, type, surname)
VALUES ('srussell001', 'PERS', 'Russell');
INSERT INTO users (id, type, corporate_name )
VALUES ('linznowe', 'CORP', 'LINZ Digital Delivery');

INSERT INTO corporation_person_xref(user_id_corporation, user_id_person)
VALUES ('linznowe', 'srussell001');

INSERT INTO documents(id, owner, user_id_owner_corporation)
VALUES (2100180, 'srussell001', 'linznowe');

INSERT INTO document_receiver (usr_id, document_id, user_id_corporation)
VALUES ('srussell001', 2100180, 'linznowe');
