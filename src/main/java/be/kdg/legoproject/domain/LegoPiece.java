package be.kdg.legoproject.domain;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// DOMAIN: plain data class with no Spring or console code.
public class LegoPiece {

    private static final Logger log =
            LoggerFactory.getLogger(LegoPiece.class);

    private final String name;
    private final String color;
    private final Material material;
    private final List<LegoSet> legoSets = new ArrayList<>();

    public LegoPiece(String name, String color, Material material) {
        this.name = name;
        this.color = color;
        this.material = material;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public Material getMaterial() {
        return material;
    }

    public List<LegoSet> getLegoSets() {
        return legoSets;
    }

    public void addLegoSet(LegoSet legoSet) {
        // Update both sides of the many-to-many relationship. contains()
        // prevents the two add methods from calling each other forever.
        if (!legoSets.contains(legoSet)) {
            legoSets.add(legoSet);
            log.debug(
                    "LEGO piece '{}' is now used in set '{}'",
                    name,
                    legoSet.getName()
            );
            legoSet.addLegoPiece(this);
        }
    }

    @Override
    public String toString() {
        return name + " (" + color + ", " + material + ")";
    }
}
