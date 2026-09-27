package be.kdg.legoproject;

import java.util.ArrayList;
import java.util.List;

public class LegoPiece {
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

    // many-to-many: keeps both sides in sync, guarded against infinite recursion
    public void addLegoSet(LegoSet legoSet) {
        if (!legoSets.contains(legoSet)) {
            legoSets.add(legoSet);
            legoSet.addLegoPiece(this);
        }
    }

    @Override
    public String toString() {
        return name + " (" + color + ", " + material + ")";
    }
}
