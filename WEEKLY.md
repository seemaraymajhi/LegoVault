# LegoVault Weekly Progress

This document contains the weekly project requirements and tracks their completion.

See [DATA.md](DATA.md) for the domain model and sample data.

## Week 1 — Domain Model and Console Application

### Domain Classes

- [x] Create the `Theme` class.
- [x] Create the `LegoSet` class.
- [x] Create the `LegoPiece` class.
- [x] Add getters for all attributes.
- [x] Add methods for managing the entity relationships.
- [x] Implement a useful `toString()` method for every entity.

### DataFactory

- [x] Create the `DataFactory` class.
- [x] Add a public static list of `LegoSet` objects.
- [x] Add a public static list of `LegoPiece` objects.
- [x] Implement the static `seed()` method.
- [x] Add at least five realistic LEGO sets.
- [x] Add at least five realistic LEGO pieces.
- [x] Establish the many-to-many relationships between sets and pieces.

### Console Application

- [x] Add an option to close the application.
- [x] Add an option to display all LEGO sets.
- [x] Filter LEGO sets using one mandatory criterion.
- [x] Add an option to display all LEGO pieces.
- [x] Filter LEGO pieces using two optional criteria.
- [x] Use filters covering three different data types.
- [x] Include filtering that is not limited to exact equality.
- [x] Display results using the entities' `toString()` methods.
- [x] Prefer streams and fluent method chains over loops.

## Week 2 — Layered Architecture and Spring Boot

### Presentation Layer

- [ ] Move the console view code into the presentation layer.
- [ ] Separate the view from the view logic.
- [ ] Implement the MVP pattern where possible.
- [ ] Let the presenter communicate with the business layer.

### Business Layer

- [ ] Create separate `domain` and `service` packages.
- [ ] Keep `Theme`, `LegoSet`, and `LegoPiece` in `domain`.
- [ ] Create `LegoSetService`.
- [ ] Create `LegoPieceService`.
- [ ] Move filtering and business operations into the services.

### Data-Access Layer

- [ ] Create the data-access layer.
- [ ] Create repositories for `LegoSet` and `LegoPiece`.
- [ ] Use streams where appropriate.

### Loose Coupling

- [ ] Add interfaces between the application layers.
- [ ] Depend on interfaces instead of concrete implementations.
- [ ] Use constructor-based dependency injection.
- [ ] Avoid creating dependencies inside the classes that use them.

### Spring Boot

- [ ] Convert the application into a Spring Boot project.
- [ ] Use component scanning.
- [ ] Add `@Component`, `@Service`, and `@Repository` where appropriate.
- [ ] Use autowiring to connect the components.
- [ ] Configure the Spring application context.
- [ ] Start the console application using `CommandLineRunner`.

### Sprint 1 Submission

- [ ] Push the completed application to the private GitLab repository.
- [ ] Merge `dev` into `main` (only `main` is graded).
- [ ] Create the `sprint1` tag on `main`.
- [ ] Push the tag to GitLab.
- [ ] Submit the tag as a comment on the assignment before the deadline.

## Week 3

Requirements will be added when the Week 3 assignment is released.