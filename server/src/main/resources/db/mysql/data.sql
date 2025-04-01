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
SELECT * FROM journeys;

ALTER TABLE flights DROP INDEX unique_flight;
ALTER TABLE flights ADD UNIQUE KEY unique_flight (departure_airport, destination_airport, distance);

INSERT INTO flights (departure_airport, destination_airport, distance) VALUES
('A', 'B', 800),
('B', 'C', 900),
('C', 'D', 400),
('D', 'E', 400),
('B', 'F', 400),
('C', 'E', 300),
('D', 'E', 300),
('E', 'B', 600),
('C', 'E', 200),
('D', 'C', 700),
('E', 'B', 500),
('F', 'D', 200);
SELECT * FROM flights;