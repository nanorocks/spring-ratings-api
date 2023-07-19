# Spring Ratings API

Spring Ratings API is a RESTful API built with Spring Boot that allows users to manage and retrieve ratings for different products. It provides endpoints for creating, updating, deleting, and retrieving ratings, as well as fetching average ratings and quantities by the product slug.

## Getting Started

### Prerequisites

Before running the Spring Ratings API, ensure you have the following installed on your machine:

- Java 11 or later
- Maven

### Installation

1. Clone the repository:

```
git clone https://github.com/nanorocks/spring-ratings-api.git
cd spring-ratings-api
```

2. Build the project:

```
mvn clean install
```


### Configuration

The application's configuration is defined in the `application.properties` file located in the `src/main/resources` directory. You can customize properties such as the database settings, server port, and logging configuration in this file.


### Usage

To run the Spring Ratings API, use the following command:

```
mvn spring-boot:run
```


The API will be available at `http://localhost:8080/api/ratings`.

### API Documentation

The API endpoints and their documentation are provided using Swagger. Once the application is running, you can access the Swagger UI at `http://localhost:8080/swagger-ui.html`. This interactive documentation allows you to explore and test the API endpoints.

### Endpoints

The Spring Ratings API provides the following endpoints:

- `GET /api/ratings`: Get all ratings.
- `GET /api/ratings/{id}`: Get rating by ID.
- `POST /api/ratings`: Create a new rating.
- `PUT /api/ratings/{id}`: Update a rating.
- `DELETE /api/ratings/{id}`: Delete a rating by ID.
- `GET /api/ratings/average`: Get average rating and quantity for all product slugs.
- `GET /api/ratings/average/{slug}`: Get average rating and quantity for a specific product slug.
- `POST /api/ratings/unique`: Create a unique rating by product slug and IP.
- `DELETE /api/ratings/remove-by-ip`: Remove ratings by IP.

### Contributing

Contributions to the Spring Ratings API are welcome! If you find a bug, have a feature request, or want to contribute code, please follow the [contribution guidelines](CONTRIBUTING.md).

### License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

### Contact

If you have any questions or need further assistance, feel free to [open an issue](https://github.com/nanorocks/spring-ratings-api/issues) or contact the project maintainers.

Happy coding! 🚀
