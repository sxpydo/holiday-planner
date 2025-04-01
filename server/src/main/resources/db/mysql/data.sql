USE holiday_planner;
INSERT INTO journeys (passengers, home_to_airport_distance, departure_airport, destination_airport)
VALUES (1, 30, 'B', 'D'),
(2, 20, 'A', 'D'),
(2, 30, 'C', 'A'),
(2, 10, 'B', 'C'),
(5, 10, 'B','C'),
(1, 25, 'D', 'B'),
(4, 40, 'D', 'A'),
(2, 5 , 'B', 'D'),
(9, 30, 'B', 'D');

ALTER TABLE flights DROP INDEX unique_flight;
ALTER TABLE flights ADD UNIQUE KEY unique_flight (departure_airport, destination_airport, distance);

INSERT INTO flights (departure_airport, destination_airport, distance) VALUES
('AB', 'B', 800),
('BC', 'C', 900),
('CD', 'D', 400),
('DE', 'E', 400),
('BF', 'F', 400),
('CE', 'E', 300),
('DE', 'E', 300),
('EB', 'B', 600),
('CE', 'E', 200),
('DC', 'C', 700),
('EB', 'B', 500),
('FD', 'D', 200);
UPDATE flights SET departure_airport = SUBSTRING(departure_airport,1,1) WHERE id <25;
SELECT * FROM flights;