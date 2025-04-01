# Holiday Planner REST API

This repository contains a Spring Boot REST API for managing holiday planning data, including flights, journeys, and cost results.

## Development Setup

To get the development environment up and running, follow these steps:

### Prerequisites

* **Java Development Kit (JDK):** Make sure you have JDK 21 or a compatible version installed.
* **Maven:** Maven is needed to build and manage project dependencies.
* **MySQL:** A MySQL database is required to store the application data. Recommend: Installing MySQL Workbench, a visual SQL editor making it easier to interact with and manage the databases.
* **Git:** Git is used for version control.
* **IDE:** An IDE like IntelliJ IDEA or VS Code with the **Spring Boot Extension Pack Plugin** *(which is the option that I have choosen)* to improve your development workflow.

### Steps

1.  **Clone the Repository:**

    ```bash
    git clone https://github.com/sxpydo/holiday-planner.git
    cd holiday-planner/server
    ```

2.  **Set up the MySQL Database:**

    * Create a MySQL database named `holiday_planner`.
    * Create a MySQL user with the necessary permissions.
    * The `src/main/resources/data.sql` and `src/main/resources/schema.sql` files contain database initialisation scripts.
    * Update the database connection properties in `src/main/resources/application.properties`:

        ```properties
        spring.datasource.url=jdbc:mysql://localhost:3306/holiday_planner
        spring.datasource.username=your_mysql_username
        spring.datasource.password=your_mysql_password
        spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
        spring.jpa.hibernate.ddl-auto=update
        spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
        ```

        Replace `your_mysql_username` and `your_mysql_password` with your MySQL credentials.

3.  **Build the Project:**

    ```bash
    ./mvnw.cmd clean install -U
    ```

    This command will download the required dependencies, compile the code, and run the tests.

4.  **Run the Application:**

    ```bash
    ./mvnw.cmd spring-boot:run
    ```

    The application will start, and you can access the REST API endpoints.

5.  **API Endpoints:**

    The API follows standard RESTful conventions for CRUD operations. Here's a brief overview:

    * **Journeys:**
        * `GET /api/journey`: Retrieve all journeys.
        * `GET /api/journey/{id}`: Retrieve a journey by ID.
        * `POST /api/journey`: Create a new journey.
            * **Request Body:** A JSON object representing the `Journey` details:
                ```json
                {
                  "departureAirport": "L",
                  "destinationAirport": "P",
                  "passengers": 2,
                  "homeToAirportDistance": 12
                }
                ```
        * `POST /api/journey/calculate`: Calculate a journey and store the journey and result.
        * `DELETE /api/journey/{id}`: Delete a journey.

6.  **Testing:**

    To run the tests, use the following command:

    ```bash
    ./mvnw.cmd test
    ```

7.  **Troubleshooting:**

    * Ensure your MySQL server is running on localhost:3306.
    * Verify that the database credentials in `application.properties` are correct.
    * If you encounter dependency issues, run `./mvnw.cmd clean install -U` to force Maven to update dependencies.
    * Check the application logs for any errors.

This setup should allow you to get the Holiday Planner REST API running on your local machine. Happy coding! 😊
