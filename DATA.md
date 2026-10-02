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
- isRetired - boolean
- imageUrl - String (image url)

## LegoPiece
- name - String
- color - String
- material - enum (PLASTIC / RUBBER / METAL)


## Relationships
- Theme -> LegoSet: one-to-many
- LegoSet <-> LegoPiece: many-to-many


## Examples

### Theme example
- name: "Star Wars"
- ageRange: "9-16"
- description: "Sets based on the Star Wars universe"

### LegoSet example
- name: "Millennium Falcon"
- pieceCount: 7541
- price: 849.99
- releaseDate: 2017-10-01
- difficulty: EXPERT
- isRetired: true
- imageUrl: "https://images.lego.com/millennium-falcon.jpg"

### LegoPiece example
- name: "2x4 Brick"
- color: "Red"
- material: PLASTIC

### Relationship examples
- "2x4 Brick" (LegoPiece) is used in both "Police Station" and "Hogwarts Castle" (LegoSet) - showing the M:N relationship
- "Star Wars" (Theme) has "Millennium Falcon" as one of its sets (LegoSet) - showing the 1:N relationship

