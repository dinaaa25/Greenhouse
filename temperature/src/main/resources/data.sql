-- SEED SCRIPT
DELETE FROM temperature_measurement;

-- ADD greenhouses
INSERT INTO temperature_measurement (id, greenhouse_id, inside_temp, outside_temp, measured_date_time) VALUES (1, 1, 25.5, 20.3, '2024-04-14 08:00:00');

INSERT INTO temperature_measurement (id, greenhouse_id, inside_temp, outside_temp, measured_date_time) VALUES (2, 2, 28.2, 22.1, '2024-04-14 09:15:00');

INSERT INTO temperature_measurement (id, greenhouse_id, inside_temp, outside_temp, measured_date_time) VALUES (3, 3, 26.8, 18.9, '2024-04-14 10:30:00');

INSERT INTO temperature_measurement (id, greenhouse_id, inside_temp, outside_temp, measured_date_time) VALUES (4, 4, 23.7, 19.6, '2024-04-14 11:45:00');

INSERT INTO temperature_measurement (id, greenhouse_id, inside_temp, outside_temp, measured_date_time) VALUES (5, 5, 27.9, 21.8, '2024-04-14 13:00:00');

INSERT INTO temperature_measurement (id, greenhouse_id, inside_temp, outside_temp, measured_date_time) VALUES (6, 6, 24.6, 20.7, '2024-04-14 14:15:00');

INSERT INTO temperature_measurement (id, greenhouse_id, inside_temp, outside_temp, measured_date_time) VALUES (7, 7, 29.1, 23.4, '2024-04-14 15:30:00');