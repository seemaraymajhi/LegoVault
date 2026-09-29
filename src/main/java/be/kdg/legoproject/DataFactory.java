package be.kdg.legoproject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataFactory {

    public static final List<LegoSet> legoSets = new ArrayList<>();
    public static final List<LegoPiece> legoPieces = new ArrayList<>();

    private DataFactory() {
        // Utility class
    }

    public static void seed() {
        legoSets.clear();
        legoPieces.clear();

        Theme starWars = new Theme(
                "Star Wars", "9+", "Sets based on the Star Wars universe");

        Theme technic = new Theme(
                "Technic", "18+", "Detailed display models for adult builders");

        Theme city = new Theme(
                "City", "5+", "Vehicles and buildings inspired by everyday life");


        LegoSet millenniumFalcon = new LegoSet(
                "Millennium Falcon", 7541, 849.99,
                LocalDate.of(2017, 10, 1),
                Difficulty.EXPERT, false,
                "https://images.brickset.com/sets/images/75192-1.jpg"
        );

        LegoSet policeStation = new LegoSet(
                "Police Station", 668, 79.99,
                LocalDate.of(2022, 1, 1),
                Difficulty.MEDIUM, false,
                "https://images.brickset.com/sets/images/60316-1.jpg"
        );

        LegoSet bugattiChiron = new LegoSet(
                "Bugatti Chiron", 3599, 349.99,
                LocalDate.of(2018, 6, 1),
                Difficulty.HARD, true,
                "https://images.brickset.com/sets/images/42083-1.jpg"
        );

        LegoSet xWing = new LegoSet(
                "Luke Skywalker's X-Wing Fighter", 474, 49.99,
                LocalDate.of(2021, 3, 1),
                Difficulty.MEDIUM, true,
                "https://images.brickset.com/sets/images/75301-1.jpg"
        );

        LegoSet fireStation = new LegoSet(
                "Fire Station", 540, 64.99,
                LocalDate.of(2022, 1, 1),
                Difficulty.EASY, false,
                "https://images.brickset.com/sets/images/60320-1.jpg"
        );

        starWars.addLegoSet(millenniumFalcon);
        starWars.addLegoSet(xWing);
        city.addLegoSet(policeStation);
        city.addLegoSet(fireStation);
        technic.addLegoSet(bugattiChiron);

        LegoPiece brick = new LegoPiece(
                "2x4 Brick", "Red", Material.PLASTIC
        );
        LegoPiece plate = new LegoPiece(
                "2x6 Plate", "Light Grey", Material.PLASTIC
        );
        LegoPiece pin = new LegoPiece(
                "Technic Pin", "Black", Material.PLASTIC
        );
        LegoPiece tyre = new LegoPiece(
                "Vehicle Tyre", "Black", Material.RUBBER
        );
        LegoPiece panel = new LegoPiece(
                "Plant Leaf", "Green", Material.PLASTIC
        );

        millenniumFalcon.addLegoPiece(plate);
        millenniumFalcon.addLegoPiece(pin);

        xWing.addLegoPiece(plate);
        xWing.addLegoPiece(panel);
        xWing.addLegoPiece(pin);

        policeStation.addLegoPiece(brick);
        policeStation.addLegoPiece(tyre);

        fireStation.addLegoPiece(brick);
        fireStation.addLegoPiece(tyre);

        bugattiChiron.addLegoPiece(pin);
        bugattiChiron.addLegoPiece(tyre);

        legoSets.addAll(List.of(
                millenniumFalcon,
                policeStation,
                bugattiChiron,
                xWing,
                fireStation
        ));

        legoPieces.addAll(List.of(
                brick,
                plate,
                pin,
                tyre,
                panel
        ));
    }
}
