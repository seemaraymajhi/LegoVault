# LegoVault Weekly Progress

This document contains the weekly project requirements and progress.

See [DATA.md](DATA.md) for the domain model and sample data.

## Week 1 — Domain Model and Console Application

### Domain Classes

- Create the `Theme` class.
- Create the `LegoSet` class.
- Create the `LegoPiece` class.
- Add getters for all attributes.
- Add methods for managing the entity relationships.
- Implement a useful `toString()` method for every entity.

### DataFactory

- Create the `DataFactory` class.
- Add a public static list of `LegoSet` objects.
- Add a public static list of `LegoPiece` objects.
- Implement the static `seed()` method.
- Add at least five realistic LEGO sets.
- Add at least five realistic LEGO pieces.
- Establish the many-to-many relationships between sets and pieces.

### Console Application

- Add an option to close the application.
- Add an option to display all LEGO sets.
- Filter LEGO sets using one mandatory criterion.
- Add an option to display all LEGO pieces.
- Filter LEGO pieces using two optional criteria.
- Use filters covering three different data types.
- Include filtering that is not limited to exact equality.
- Display results using the entities' `toString()` methods.
- Prefer streams and fluent method chains over loops.

## Week 2 — Layered Architecture and Spring Boot

### Presentation Layer

- Move the console view code into the presentation layer.
- Separate the view from the view logic.
- Implement the MVP pattern where possible.
- Let the presenter communicate with the business layer.

### Business Layer

- Create separate `domain` and `service` packages.
- Keep `Theme`, `LegoSet`, and `LegoPiece` in `domain`.
- Create `LegoSetService`.
- Create `LegoPieceService`.
- Move filtering and business operations into the services.

### Data-Access Layer

- Create the data-access layer.
- Create repositories for `LegoSet` and `LegoPiece`.
- Use streams where appropriate.

### Loose Coupling

- Add interfaces between the application layers.
- Depend on interfaces instead of concrete implementations.
- Use constructor-based dependency injection.
- Avoid creating dependencies inside the classes that use them.

### Spring Boot

- Convert the application into a Spring Boot project.
- Use component scanning.
- Add `@Component`, `@Service`, and `@Repository` where appropriate.
- Use autowiring to connect the components.
- Configure the Spring application context.
- Start the console application using `CommandLineRunner`.

### Sprint 1 Submission

- Push the completed application to the private GitLab repository.
- Merge `dev` into `main` (only `main` is graded).
- Create the annotated `sprint1` tag on `main`.
- Push the tag to GitLab.
- Submit the tag as a comment on the assignment before the deadline.

## Week 3 - Web Front End

### Web Application

- Add a web front end while keeping the console application available.
- Provide the existing console functionality through the web interface.
- Create pages for LEGO sets, LEGO pieces, adding a LEGO set, and adding a LEGO piece.
- Add navigation to all four pages.

### LEGO Sets

- Display all LEGO sets in a table.
- Show all attributes except relationship attributes.
- Add one mandatory filter criterion.
- Add a form for creating a LEGO set.
- Allow a related LEGO piece to be selected when creating a LEGO set.
- Save the submitted LEGO set through the repository layer.

### LEGO Pieces

- Display all LEGO pieces in a table.
- Show all attributes except relationship attributes.
- Add two optional filter criteria.
- Add a form for creating a LEGO piece.
- Save the submitted LEGO piece through the repository layer.

### Filtering and Logging

- Filter across three different data types.
- Include filtering that is not limited to exact equality.
- Add a logger to every class.
- Log debug messages in complex methods, excluding getters and setters.
- Enable debug logging through `application.properties`.

## Week 4 - Thymeleaf

### Reusable Views

- Use a Thymeleaf fragment for the shared navigation.
- Include the navigation fragment on every page.
- Add a custom CSS file under `src/main/resources/static`.
- Load the CSS file using Thymeleaf URL syntax.

### Internationalization

- Add support for a second language.
- Move all static text into message property files.
- Provide a message property file for each language.
- Verify that the displayed language follows the browser preference.

### Additional Thymeleaf Functionality

- Use the Thymeleaf `#lists` utility.
- Display the number of items underneath each table.

### Sprint 2 Submission

- Complete the Week 3 and Week 4 requirements.
- Push the completed application to GitLab.
- Merge `dev` into `main` for the Sprint 2 release.
- Create the `sprint2` tag on `main`.
- Push the tag to GitLab.
- Submit the tag as a comment on the assignment.