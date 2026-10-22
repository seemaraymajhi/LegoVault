# LegoVault

See [WEEKLY.md](WEEKLY.md) for the weekly requirements and progress.

## Theme
- name - String
- ageRange - String
- description - String

## LegoSet
- name - String
- pieceCount - int
- price - double
- releaseDate - LocalDate
- difficulty - enum (EASY / MEDIUM / HARD / EXPERT)
- retired - boolean
- imageUrl - String (image URL)

## LegoPiece
- name - String
- color - String
- material - enum (PLASTIC / RUBBER / METAL)

## Relationships
- Theme → LegoSet: one-to-many
- LegoSet ↔ LegoPiece: many-to-many

## Examples

### Theme example
- name: "Star Wars"
- ageRange: "9+"
- description: "Sets based on the Star Wars universe"

### LegoSet example
- name: "Millennium Falcon"
- pieceCount: 7541
- price: 849.99
- releaseDate: 2017-10-01
- difficulty: EXPERT
- retired: false
- imageUrl: "https://images.brickset.com/sets/images/75192-1.jpg"

### LegoPiece example
- name: "2x4 Brick"
- color: "Red"
- material: PLASTIC

### Relationship examples
- "2x4 Brick" (LegoPiece) is used in both "Police Station" and "Hogwarts Castle" (LegoSet), showing the many-to-many relationship.
- "Star Wars" (Theme) has "Millennium Falcon" as one of its sets (LegoSet), showing the one-to-many relationship.
