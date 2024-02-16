CREATE OR REPLACE FUNCTION update_last_updated_at()
    RETURNS TRIGGER AS '
    BEGIN
        NEW.car_last_updated_at = CURRENT_TIMESTAMP;
        RETURN NEW;
    END;'
    LANGUAGE plpgsql;


CREATE TRIGGER car_last_updated_trigger
    BEFORE UPDATE ON car
    FOR EACH ROW
EXECUTE FUNCTION update_last_updated_at();

INSERT INTO person (person_name, person_age)
VALUES
    ('Sophia', 26),
    ('Michael', 32),
    ('Emma', 29),
    ('William', 37),
    ('Olivia', 24),
    ('James', 41),
    ('Ava', 28),
    ('Benjamin', 30),
    ('Charlotte', 33),
    ('Liam', 35),
    ('Harper', 31),
    ('Elijah', 27),
    ('Mia', 38),
    ('Henry', 36),
    ('Amelia', 25),
    ('Sebastian', 34),
    ('Evelyn', 23),
    ('Alexander', 39),
    ('Abigail', 22),
    ('Daniel', 40);

INSERT INTO autoservice (autoservice_address, autoservice_country, autoservice_name)
VALUES
    ('888 Pine Ave', 'Russia', 'Auto Service 11'),
    ('999 Elm St', 'Russia', 'Auto Service 12'),
    ('777 Oak Rd', 'Kazakhstan', 'Auto Service 13'),
    ('555 Cedar Ave', 'Ukraine', 'Auto Service 14'),
    ('333 Maple Pl', 'Russia', 'Auto Service 15'),
    ('111 Birch Rd', 'Kazakhstan', 'Auto Service 16'),
    ('666 Willow Ln', 'Ukraine', 'Auto Service 17'),
    ('444 Oakwood Rd', 'Russia', 'Auto Service 18'),
    ('222 Forest Ave', 'Kazakhstan', 'Auto Service 19'),
    ('999 Park Rd', 'Ukraine', 'Auto Service 20');

INSERT INTO car (car_release_date, car_color, car_model, car_evp, car_created_at, car_last_updated_at, person_id, autoservice_id)
VALUES
    ('2023-11-05', 'Red', 'LADA', 14000, NOW(), NOW(), 1, 1),
    ('2023-12-10', 'Blue', 'MOSKVITCH', 19000, NOW(), NOW(), 1, 8),
    ('2023-12-15', 'Black', 'LADA', 17000, NOW(), NOW(), 1, 7),
    ('2024-01-20', 'Gray', 'MOSKVITCH', 21000, NOW(), NOW(), 2, 1),
    ('2024-02-25', 'White', 'LADA', 23000, NOW(), NOW(), 3, 6),
    ('2024-03-01', 'Brown', 'MOSKVITCH', 20000, NOW(), NOW(), 4, 9),
    ('2024-04-05', 'Silver', 'LADA', 26000, NOW(), NOW(), 4, 1),
    ('2024-05-10', 'Green', 'MOSKVITCH', 13000, NOW(), NOW(), 5, 3),
    ('2024-06-15', 'Burgundy', 'LADA', 18000, NOW(), NOW(), 19, 5),
    ('2024-07-20', 'Orange', 'MOSKVITCH', 16000, NOW(), NOW(), 20, 1);