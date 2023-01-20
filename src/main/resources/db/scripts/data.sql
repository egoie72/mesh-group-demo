BEGIN;

INSERT INTO meshgroupdemo.user (name, password, date_of_birth) VALUES ('Test1', '123456', '2000-01-01');
INSERT INTO meshgroupdemo.user (name, password, date_of_birth) VALUES ('Test2', '654321', '2000-01-02');
INSERT INTO meshgroupdemo.user (name, password, date_of_birth) VALUES ('Test3', '654987', '2000-01-03');
INSERT INTO meshgroupdemo.user (name, password, date_of_birth) VALUES ('Test4', '321654', '2000-01-04');

INSERT INTO meshgroupdemo.account (user_id, balance)
 VALUES ((SELECT id FROM meshgroupdemo.user WHERE name = 'Test1'), 100);
INSERT INTO meshgroupdemo.account (user_id, balance)
 VALUES ((SELECT id FROM meshgroupdemo.user WHERE name = 'Test2'), 110);
INSERT INTO meshgroupdemo.account (user_id, balance)
 VALUES ((SELECT id FROM meshgroupdemo.user WHERE name = 'Test3'), 120);
INSERT INTO meshgroupdemo.account (user_id, balance)
 VALUES ((SELECT id FROM meshgroupdemo.user WHERE name = 'Test4'), 130);

INSERT INTO meshgroupdemo.email_data (user_id, email)
VALUES ((SELECT id FROM meshgroupdemo.user WHERE name = 'Test1'), 'test1@domain.ru');
INSERT INTO meshgroupdemo.email_data (user_id, email)
VALUES ((SELECT id FROM meshgroupdemo.user WHERE name = 'Test2'), 'test2@domain.ru');
INSERT INTO meshgroupdemo.email_data (user_id, email)
VALUES ((SELECT id FROM meshgroupdemo.user WHERE name = 'Test3'), 'test3@domain.ru');
INSERT INTO meshgroupdemo.email_data (user_id, email)
VALUES ((SELECT id FROM meshgroupdemo.user WHERE name = 'Test4'), 'test4@domain.ru');
INSERT INTO meshgroupdemo.email_data (user_id, email)
VALUES ((SELECT id FROM meshgroupdemo.user WHERE name = 'Test4'), 'test4.new@domain.ru');

INSERT INTO meshgroupdemo.phone_data (user_id, phone)
VALUES ((SELECT id FROM meshgroupdemo.user WHERE name = 'Test1'), '79131234567');
INSERT INTO meshgroupdemo.phone_data (user_id, phone)
VALUES ((SELECT id FROM meshgroupdemo.user WHERE name = 'Test1'), '79133216549');
INSERT INTO meshgroupdemo.phone_data (user_id, phone)
VALUES ((SELECT id FROM meshgroupdemo.user WHERE name = 'Test2'), '79139876541');
INSERT INTO meshgroupdemo.phone_data (user_id, phone)
VALUES ((SELECT id FROM meshgroupdemo.user WHERE name = 'Test3'), '79136549812');
INSERT INTO meshgroupdemo.phone_data (user_id, phone)
VALUES ((SELECT id FROM meshgroupdemo.user WHERE name = 'Test4'), '79137893214');

COMMIT;
