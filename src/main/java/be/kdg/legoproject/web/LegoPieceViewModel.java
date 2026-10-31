package be.kdg.legoproject.web;

import be.kdg.legoproject.domain.Material;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import jakarta.validation.constraints.*;

// Holds what the user typed in the "Add LEGO Piece" form.
// Spring creates it with the empty constructor and fills it using the setters.
public class LegoPieceViewModel {

    private static final Logger log =
            LoggerFactory.getLogger(LegoPieceViewModel.class);

    @NotBlank(message = "{legopiece.name.notBlank}")
    @Size(max = 50, message = "{legopiece.name.size}")
    private String name;

    @NotBlank(message = "{legopiece.color.notBlank}")
    private String color;

    @NotNull(message = "{legopiece.material.notNull}")
    private Material material;

    public LegoPieceViewModel() {
        log.debug("Created a LegoPieceViewModel backing object");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
}
