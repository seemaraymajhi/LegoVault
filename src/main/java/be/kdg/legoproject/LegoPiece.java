package be.kdg.legoproject;

public class LegoPiece {
    private final String name;
    private final String color;
    private final Material material;

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

    @Override
    public String toString() {
        return name + " (" + color + ", " + material + ")";
    }
}
