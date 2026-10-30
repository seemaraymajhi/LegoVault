# LegoVault

A Spring Boot web application for browsing and adding LEGO sets and the pieces they use.
The original console menu is still available.

**Author:** Seema Raymajhi

## Domain

| Entity | Fields |
|---|---|
| **Theme** | name, ageRange, description |
| **LegoSet** | name, pieceCount, price, releaseDate, difficulty (`EASY` / `MEDIUM` / `HARD` / `EXPERT`), retired, imageUrl |
| **LegoPiece** | name, color, material (`PLASTIC` / `RUBBER` / `METAL`) |

Relationships:
- **Theme → LegoSet**: one-to-many (a theme has many sets, each set belongs to one theme)
- **LegoSet ↔ LegoPiece**: many-to-many (a set contains many pieces, a piece can appear in many sets)

See [DATA.md](DATA.md) for example data.

## Features

### Web application
| Page | URL | What it does |
|---|---|---|
| LEGO Sets | `/legosets` | Sets as responsive Bootstrap cards (1/2/4 columns); filter on minimum number of pieces |
| LEGO Set details | `/legosets/{id}` | All details of one set, its theme and its pieces |
| LEGO Pieces | `/legopieces` | Table of pieces; optional filters on name and material |
| Add LEGO Set | `/legosets/add` | Form to add a set, linked to an existing piece |
| Add LEGO Piece | `/legopieces/add` | Form to add a piece |

- Navbar and footer are Thymeleaf fragments
- Styling with Bootstrap and Bootstrap Icons (loaded via WebJars)
- English and Dutch (follows the browser language)

### Console menu
1. Show all LEGO sets
2. Show LEGO sets with at least X pieces
3. Show all LEGO pieces
4. Show LEGO pieces by name and/or material (both filters optional)

## Requirements
- Java 25 (Gradle's toolchain setting selects it)
- No database needed yet: data is stored in memory and seeded at startup by `DataFactory`

## How to run

**Web application:**

```
./gradlew bootRun
```

Then open http://localhost:8080/legosets

**With the console menu:**

```
./gradlew bootRun --args='--console'
```

The web application also runs in this mode.

**Dutch version:** set your browser's preferred language to Dutch and refresh the page.
