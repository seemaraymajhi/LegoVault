package be.kdg.legoproject;

import java.util.ArrayList;
import java.util.List;

public class Theme {
    private final String name;
    private final String ageRange;
    private final String description;
    private final List<LegoSet> legoSets = new ArrayList<>();

    public Theme(String name, String ageRange, String description) {
        this.name = name;
        this.ageRange = ageRange;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getAgeRange() {
        return ageRange;
    }

    public String getDescription() {
        return description;
    }

    public List<LegoSet> getLegoSets() {
        return legoSets;
    }

    public void addLegoSet(LegoSet legoSet) {
        legoSets.add(legoSet);
        legoSet.setTheme(this);
    }

    @Override
    public String toString() {
        return name + " (" + ageRange + ") - " + description;
    }
}
