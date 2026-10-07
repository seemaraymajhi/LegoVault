package be.kdg.legoproject.domain;

import java.util.ArrayList;
import java.util.List;

// DOMAIN: plain data class with no Spring or console code.
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
        // Maintain both sides: Theme knows its sets and each set knows its Theme.
        if (!legoSets.contains(legoSet)) {
            legoSets.add(legoSet);
            legoSet.setTheme(this);
        }
    }

    @Override
    public String toString() {
        return name + " (" + ageRange + ") - " + description;
    }
}
