package be.kdg.legoproject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LegoSet {
    private final String name;
    private final int pieceCount;
    private final double price;
    private final LocalDate releaseDate;
    private final Difficulty difficulty;
    private final boolean retired;
    private final String imageUrl;
    private Theme theme;
    private final List<LegoPiece> legoPieces = new ArrayList<>();

    public LegoSet(String name, int pieceCount, double price, LocalDate releaseDate,
                    Difficulty difficulty, boolean retired, String imageUrl) {
        this.name = name;
        this.pieceCount = pieceCount;
        this.price = price;
        this.releaseDate = releaseDate;
        this.difficulty = difficulty;
        this.retired = retired;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public int getPieceCount() {
        return pieceCount;
    }

    public double getPrice() {
        return price;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public boolean isRetired() {
        return retired;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Theme getTheme() {
        return theme;
    }

    // called from Theme.addLegoSet - keeps the one-to-many relationship in sync
    void setTheme(Theme theme) {
        this.theme = theme;
    }

    public List<LegoPiece> getLegoPieces() {
        return legoPieces;
    }

    // many-to-many: keeps both sides in sync, guarded against infinite recursion
    public void addLegoPiece(LegoPiece legoPiece) {
        if (!legoPieces.contains(legoPiece)) {
            legoPieces.add(legoPiece);
            legoPiece.addLegoSet(this);
        }
    }

    @Override
    public String toString() {
        return name + " [" + pieceCount + " pcs, EUR " + price + ", " + difficulty
                + (retired ? ", RETIRED" : "") + "]";
    }
}
