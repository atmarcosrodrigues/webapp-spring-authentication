
<h1 align="center">
   Web App Multi-tenancy Authentication
</h1>



This application provides a Multi-tenancy backend API, using a shared database/schema [1]. The structure for managing users, tenant/customers, roles, rules and responsibilities is built using Spring OAuth2.



* ## Technologies
    * [Java](https://www.java.com/)
	* [Spring Boot](https://spring.io/projects/spring-boot)
	* [Docker](https://www.docker.com/)
	* [PostgreSQL](https://www.postgresql.org/)

* ## Installation / Usage

    * Git clone this repository
    * Access the main directory, update docker/application files according to your database settings
    * Run the command below to create the backend/database structure:

    ```
    docker compose up -d
    ```
    * Access the address below to see the services provided by the backend API:
        http://localhost:8080/swagger-ui/index.html



* ## Learn More

    [1] https://www.baeldung.com/multitenancy-with-spring-data-jpa

