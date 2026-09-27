# LegoVault

A console application for browsing a collection of LEGO sets and the pieces they use.

## Domain

| Entity | Fields |
|---|---|
| **Theme** | name, ageRange, description |
| **LegoSet** | name, pieceCount, price, releaseDate, difficulty (`EASY` / `MEDIUM` / `HARD` / `EXPERT`), retired, imageUrl |
| **LegoPiece** | name, color, material (`PLASTIC` / `RUBBER` / `METAL`) |

Relationships:
- **Theme → LegoSet**: one-to-many (a theme has many sets, each set belongs to one theme)
- **LegoSet ↔ LegoPiece**: many-to-many (a set contains many pieces, a piece can appear in many sets)

See [data.md](DATA.md) for example data.

## Features

The console menu offers:

1. Show all LEGO sets
2. Show LEGO sets with at least X pieces
3. Show all LEGO pieces
4. Show LEGO pieces by name and/or material (both filters optional)

## Requirements

- Java 21 (Gradle's toolchain setting takes care of selecting it)




