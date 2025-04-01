USE holiday_planner;

CREATE TABLE flights (
    id INT AUTO_INCREMENT PRIMARY KEY,
    departure_airport VARCHAR(3) NOT NULL,
    destination_airport VARCHAR(3) NOT NULL,
    distance INT NOT NULL,
    UNIQUE KEY unique_flight (departure_airport, destination_airport)
);

CREATE TABLE journeys (
    id INT AUTO_INCREMENT PRIMARY KEY,
    passengers INT NOT NULL,
    home_to_airport_distance INT NOT NULL,
    departure_airport VARCHAR(3) NOT NULL,
    destination_airport VARCHAR(3) NOT NULL
);

CREATE TABLE results (
    id INT AUTO_INCREMENT PRIMARY KEY,
    journey_id INT NOT NULL,
    vehicle VARCHAR(10) NOT NULL,
    return_cost DECIMAL(10, 2) NOT NULL,
    outbound_route VARCHAR(255),
    outbound_cost DECIMAL(10, 2),
    inbound_route VARCHAR(255),
    inbound_cost DECIMAL(10, 2),
    total_cost DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (journey_id) REFERENCES journeys(id)
);