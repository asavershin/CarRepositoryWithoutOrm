CREATE TABLE car (
                     car_id serial PRIMARY KEY,
                     car_release_date date NOT NULL,
                     car_color varchar(10) NOT NULL,
                     car_model varchar(15) NOT NULL,
                     car_evp bigint NOT NULL UNIQUE,
                     car_created_at timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL,
                     car_last_updated_at timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL,
                     person_id bigint,
                     autoservice_id bigint,
                     CONSTRAINT fk_car_person FOREIGN KEY (person_id) REFERENCES person(person_id) ON DELETE SET NULL,
                     CONSTRAINT fk_car_autoservice FOREIGN KEY (autoservice_id) REFERENCES autoservice(autoservice_id) ON DELETE SET NULL
);

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