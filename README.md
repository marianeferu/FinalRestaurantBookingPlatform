2020

The Restaurant Booking Platform backend is a Spring Boot application built in 2020 designed to handle restaurant reservations. It follows a layered architecture with well-organized components, including controllers, services, repositories, and DTOs. The system ensures data validation, error handling, and test coverage, making it robust and scalable.

Technology Stack
    Java (Spring Boot)
    Spring MVC (RESTful APIs)
    Spring Data JPA (for database interaction)
    H2/MySQL (Database)
    JUnit & Mockito (Unit Testing)
    Swagger (API Documentation)

Project Structure
  1. Controller Layer
     Located in the controller package, this layer handles HTTP requests and maps them to appropriate service methods.

     Uses @RestController, @RequestMapping for defining REST endpoints.
     @Autowired is used for dependency injection.
     Supports various HTTP methods with annotations like @PostMapping, @GetMapping, and @DeleteMapping.

  2. DTO (Data Transfer Objects)
      The dto package contains lightweight objects to transfer data between layers.

      Uses @Getter, @Setter, @Builder, @AllArgsConstructor, and @NoArgsConstructor.
      Implements validation constraints like @NotNull, @Size, and custom @OnlyLetters annotation for input validation.

  3. Exception Handling
      Custom exceptions are handled in the exceptions package, ensuring that meaningful error messages are returned to clients.

  4. Mappers
      The mappers package contains @Component annotated classes to map between DTOs and entity models.

  5. Model (Entity Layer)
      Entities are located in the model package, representing database tables and using JPA annotations.

  6. Repository Layer
      The repository package interfaces with the database using Spring Data JPA.

      @Repository annotation for repository classes.
      @Autowired JdbcTemplate for direct SQL queries.

  7. Service Layer
      The service package contains business logic and is annotated with @Service for dependency injection.

  8. Validators
      Custom validators are defined in the validators package.

      Uses @interface OnlyLetters for validation.
      Implements ConstraintValidator in OnlyLettersValidator, ensuring string fields contain only letters.

  9. Database Configuration
      The restaurantdb.sql script contains SQL commands to initialize and manage the database schema.

  10. Testing
      Unit tests are located in the test package.

      Uses @ExtendWith(MockitoExtension.class) for testing.
      Mocks repository dependencies with @Mock and injects them into services using @InjectMocks.
      Ensures proper test coverage with @Test annotated methods.

  11. Application Bootstrap
      The main application class RestaurantBookingPlatformApplication is annotated with:
      @SpringBootApplication (Bootstraps the application).
      @EnableSwagger2 (Enables Swagger for API documentation).
    





