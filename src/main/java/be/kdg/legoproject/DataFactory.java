package be.kdg.legoproject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataFactory {

    // the two many-to-many entities
    public static List<LegoSet> legoSets = new ArrayList<>();
    public static List<LegoPiece> legoPieces = new ArrayList<>();

    public static void seed() {
        // --- Themes (one-to-many owner side, not a many-to-many list) ---
        Theme starWars = new Theme("Star Wars", "9-16", "Sets based on the Star Wars universe");
        Theme city = new Theme("City", "5-12", "Everyday city life sets");
        Theme technic = new Theme("Technic", "10+", "Mechanical, gear-driven builds");
        Theme harryPotter = new Theme("Harry Potter", "8-14", "Wizarding world sets");
        Theme speedChampions = new Theme("Speed Champions", "9+", "Racing car sets");

        // --- LegoSets ---
        LegoSet millenniumFalcon = new LegoSet("Millennium Falcon", 7541, 849.99,
                LocalDate.of(2017, 10, 1), Difficulty.EXPERT, true,
                "https://images.lego.com/millennium-falcon.jpg");
        LegoSet policeStation = new LegoSet("Police Station", 668, 79.99,
                LocalDate.of(2022, 6, 1), Difficulty.MEDIUM, false,
                "https://images.lego.com/police-station.jpg");
        LegoSet bugattiChiron = new LegoSet("Bugatti Chiron", 3599, 349.99,
                LocalDate.of(2018, 8, 1), Difficulty.HARD, true,
                "https://images.lego.com/bugatti-chiron.jpg");
        LegoSet hogwartsCastle = new LegoSet("Hogwarts Castle", 6020, 469.99,
                LocalDate.of(2018, 9, 1), Difficulty.EXPERT, false,
                "https://images.lego.com/hogwarts-castle.jpg");
        LegoSet ferrariF1Car = new LegoSet("Ferrari F1 Car", 1854, 219.99,
                LocalDate.of(2024, 3, 1), Difficulty.HARD, false,
                "https://images.lego.com/ferrari-f1.jpg");

        // link LegoSet -> Theme (one-to-many, owned by Theme)
        starWars.addLegoSet(millenniumFalcon);
        city.addLegoSet(policeStation);
        technic.addLegoSet(bugattiChiron);
        harryPotter.addLegoSet(hogwartsCastle);
        speedChampions.addLegoSet(ferrariF1Car);

        // --- LegoPieces ---
        LegoPiece brick2x4 = new LegoPiece("2x4 Brick", "Red", Material.PLASTIC);
        LegoPiece roundPlate = new LegoPiece("1x1 Round Plate", "Black", Material.PLASTIC);
        LegoPiece minifigHead = new LegoPiece("Minifig Head", "Yellow", Material.PLASTIC);
        LegoPiece technicPin = new LegoPiece("Technic Pin", "Gray", Material.PLASTIC);
        LegoPiece wheelRim = new LegoPiece("Wheel Rim", "Silver", Material.RUBBER);
        LegoPiece transparentPanel = new LegoPiece("Transparent Panel", "Clear", Material.PLASTIC);

        // --- many-to-many links: LegoSet <-> LegoPiece ---
        // brick2x4 used in MANY sets
        brick2x4.addLegoSet(policeStation);
        brick2x4.addLegoSet(hogwartsCastle);

        // roundPlate used in exactly ONE set
        roundPlate.addLegoSet(millenniumFalcon);

        // minifigHead used in NO sets (deliberately left unlinked)

        // technicPin used in MANY sets
        technicPin.addLegoSet(bugattiChiron);
        technicPin.addLegoSet(ferrariF1Car);

        // wheelRim used in ONE set
        wheelRim.addLegoSet(ferrariF1Car);

        // transparentPanel used in MANY sets
        transparentPanel.addLegoSet(hogwartsCastle);
        transparentPanel.addLegoSet(millenniumFalcon);

        legoSets.add(millenniumFalcon);
        legoSets.add(policeStation);
        legoSets.add(bugattiChiron);
        legoSets.add(hogwartsCastle);
        legoSets.add(ferrariF1Car);

        legoPieces.add(brick2x4);
        legoPieces.add(roundPlate);
        legoPieces.add(minifigHead);
        legoPieces.add(technicPin);
        legoPieces.add(wheelRim);
        legoPieces.add(transparentPanel);
    }
}
