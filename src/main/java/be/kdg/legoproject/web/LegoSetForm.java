package be.kdg.legoproject.web;

import be.kdg.legoproject.domain.Difficulty;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

// Holds what the user typed in the "Add LEGO Set" form.
// Spring creates it with the empty constructor and fills it using the setters.
public class LegoSetForm {

    private String name;
    private int pieceCount;
    private double price;

    // The date picker sends text like "2021-11-01"; this tells Spring how to read it.
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate releaseDate;

    private Difficulty difficulty;
    private boolean retired;
    private String imageUrl;

    // The name of the chosen LEGO piece (for the many-to-many link).
    private String pieceName;

    public LegoSetForm() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPieceCount() {
        return pieceCount;
    }

    public void setPieceCount(int pieceCount) {
        this.pieceCount = pieceCount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public boolean isRetired() {
        return retired;
    }

    public void setRetired(boolean retired) {
        this.retired = retired;
    }

    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPieceName() {
        return pieceName;
    }
    public void setPieceName(String pieceName) {
        this.pieceName = pieceName;
    }
}