package be.kdg.legoproject.web;

import be.kdg.legoproject.domain.Material;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Holds what the user typed in the "Add LEGO Piece" form.
// Spring creates it with the empty constructor and fills it using the setters.
public class LegoPieceForm {

    private static final Logger log =
            LoggerFactory.getLogger(LegoPieceForm.class);

    private String name;
    private String color;
    private Material material;

    public LegoPieceForm() {
        log.debug("Created a LegoPieceForm backing object");
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