package be.kdg.legoproject.repository;

import be.kdg.legoproject.domain.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataFactory {

    public static final List<LegoSet> legoSets = new ArrayList<>();
    public static final List<LegoPiece> legoPieces = new ArrayList<>();
    public static final List<Theme> themes = new ArrayList<>();


    @PostConstruct
    public void init() {
        seed();
    }


    public static void seed() {
        legoSets.clear();
        legoPieces.clear();
        themes.clear();

        Theme starWars = new Theme(
                "Star Wars", "9+", "Sets based on the Star Wars universe");

        Theme technic = new Theme(
                "Technic", "18+", "Detailed display models for adult builders");

        Theme city = new Theme(
                "City", "5+", "Vehicles and buildings inspired by everyday life");

        Theme speedChampions = new Theme(
                "Speed Champions", "9+", "Detailed LEGO models of famous cars");

        Theme creatorExpert = new Theme(
                "Creator Expert", "18+", "Advanced display models for experienced builders");

        Theme architecture = new Theme(
                "Architecture", "13+", "Models of famous buildings and landmarks");

        Theme friends = new Theme(
                "Friends", "6+", "Sets focused on Heartlake City and its characters");

        Theme ninjago = new Theme(
                "Ninjago", "7+", "Action sets based on the Ninjago universe");

        Theme harryPotter = new Theme(
                "Harry Potter", "9+", "Sets based on the Harry Potter world");

        Theme ideas = new Theme(
                "Ideas", "18+", "Fan-designed LEGO sets selected for production");


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

        LegoSet ferrari = new LegoSet(
                "Ferrari 812 Competizione", 261, 24.99,
                LocalDate.of(2023, 3, 1),
                Difficulty.EASY, false,
                "https://images.brickset.com/sets/images/76914-1.jpg"
        );

        LegoSet eiffelTower = new LegoSet(
                "Eiffel Tower", 10001, 629.99,
                LocalDate.of(2022, 11, 25),
                Difficulty.EXPERT, false,
                "https://images.brickset.com/sets/images/10307-1.jpg"
        );

        LegoSet hogwartsCastle = new LegoSet(
                "Hogwarts Castle", 6020, 469.99,
                LocalDate.of(2018, 9, 1),
                Difficulty.EXPERT, true,
                "https://images.brickset.com/sets/images/71043-1.jpg"
        );

        LegoSet ninjaDojo = new LegoSet(
                "Ninja Dojo Temple", 1394, 99.99,
                LocalDate.of(2022, 1, 1),
                Difficulty.HARD, false,
                "https://images.brickset.com/sets/images/71767-1.jpg"
        );

        LegoSet centralPerk = new LegoSet(
                "Central Perk", 1070, 69.99,
                LocalDate.of(2019, 9, 1),
                Difficulty.MEDIUM, true,
                "https://images.brickset.com/sets/images/21319-1.jpg"
        );

        starWars.addLegoSet(millenniumFalcon);
        starWars.addLegoSet(xWing);
        city.addLegoSet(policeStation);
        city.addLegoSet(fireStation);
        technic.addLegoSet(bugattiChiron);

        speedChampions.addLegoSet(ferrari);
        creatorExpert.addLegoSet(eiffelTower);
        harryPotter.addLegoSet(hogwartsCastle);
        ninjago.addLegoSet(ninjaDojo);
        ideas.addLegoSet(centralPerk);

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

        LegoPiece windshield = new LegoPiece(
                "Car Windshield", "Transparent", Material.PLASTIC
        );

        LegoPiece axle = new LegoPiece(
                "Technic Axle", "Grey", Material.PLASTIC
        );

        LegoPiece wheelRim = new LegoPiece(
                "Wheel Rim", "Silver", Material.PLASTIC
        );

        LegoPiece chain = new LegoPiece(
                "Small Chain", "Dark Grey", Material.METAL
        );

        LegoPiece rubberBand = new LegoPiece(
                "Rubber Band", "Black", Material.RUBBER
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

        ferrari.addLegoPiece(windshield);

        eiffelTower.addLegoPiece(chain);

        hogwartsCastle.addLegoPiece(brick);
        hogwartsCastle.addLegoPiece(panel);

        ninjaDojo.addLegoPiece(axle);
        ninjaDojo.addLegoPiece(chain);
        ninjaDojo.addLegoPiece(rubberBand);


        legoSets.addAll(List.of(
                millenniumFalcon,
                policeStation,
                bugattiChiron,
                xWing,
                fireStation,
                ferrari,
                eiffelTower,
                hogwartsCastle,
                ninjaDojo,
                centralPerk
        ));

        legoPieces.addAll(List.of(
                brick,
                plate,
                pin,
                tyre,
                panel,
                windshield,
                axle,
                wheelRim,
                chain,
                rubberBand
        ));

        themes.addAll(List.of(
                starWars,
                technic,
                city,
                speedChampions,
                creatorExpert,
                architecture,
                friends,
                ninjago,
                harryPotter,
                ideas
        ));
    }
}
