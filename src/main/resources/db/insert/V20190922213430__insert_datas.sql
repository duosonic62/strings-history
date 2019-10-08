-- Insert Member Information
INSERT INTO member (id, uid, name, token, token_expired, is_deleted, version, created_at, updated_at)
VALUES ('4E8F28ED-A9C6-4673-924A-9C5966D082C8', 'C8E184B0-DB5B-45F5-B26C-337ADFE0BF9D', 'Lowell',
        'F24BF136-E012-4199-800C-A25CB216891B', (now() + interval 1 day), false, 1, now(), now())
INSERT INTO member (id, uid, name, token, token_expired, is_deleted, version, created_at, updated_at)
VALUES ('0DECD4D5-EB29-456E-BA77-0DBA60A96A1E', 'D349036A-46B8-4EE4-943F-EF16F85637FD', 'Bonny',
        '53B7AEEF-BD2E-41B6-8B95-D54254D51150', (now() + interval 1 day), false, 1, now(), now())