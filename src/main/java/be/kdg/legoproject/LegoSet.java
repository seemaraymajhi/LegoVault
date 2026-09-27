package be.kdg.legoproject;

import java.time.LocalDate;

public class LegoSet {
    private final String name;
    private final int pieceCount;
    private final double price;
    private final LocalDate releaseDate;
    private final Difficulty difficulty;
    private final boolean retired;
    private final String imageUrl;
    private Theme theme;

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

    void setTheme(Theme theme) {
        this.theme = theme;
    }

    @Override
    public String toString() {
        return name + " [" + pieceCount + " pieces, EUR " + price + ", "
                + difficulty + (retired ? ", retired" : "") + "]";
    }
}
