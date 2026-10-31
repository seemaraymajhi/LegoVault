package be.kdg.legoproject.web;

import be.kdg.legoproject.domain.Difficulty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

// Holds what the user typed in the "Add LEGO Set" form.
// Spring creates it with the empty constructor and fills it using the setters.
public class LegoSetViewModel {

    private static final Logger log =
            LoggerFactory.getLogger(LegoSetViewModel.class);

    private String name;
    private Integer pieceCount;
    private Double price;

    // The date picker sends text like "2021-11-01"; this tells Spring how to read it.
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate releaseDate;

    private Difficulty difficulty;
    private boolean retired;
    private String imageUrl;

    // The name of the chosen LEGO piece (for the many-to-many link).
    private String pieceName;

    public LegoSetViewModel() {
        log.debug("Created a LegoSetViewModel backing object");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPieceCount() {
        return pieceCount;
    }

    public void setPieceCount(Integer pieceCount) {
        this.pieceCount = pieceCount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
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
