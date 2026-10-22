package be.kdg.legoproject.presentation;

import be.kdg.legoproject.service.LegoPieceService;
import be.kdg.legoproject.service.LegoSetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;


// Coordinates the View and business services.
@Component
public class Presenter implements CommandLineRunner {

    private static final Logger log =
            LoggerFactory.getLogger(Presenter.class);

    private final View view;
    private final LegoSetService legoSetService;
    private final LegoPieceService legoPieceService;

    public Presenter(
            View view,
            LegoSetService legoSetService,
            LegoPieceService legoPieceService
    ) {
        this.view = view;
        this.legoSetService = legoSetService;
        this.legoPieceService = legoPieceService;
    }

    @Override
    public void run(String... args) {
        boolean consoleMode = Arrays.stream(args)
                .anyMatch("--console"::equalsIgnoreCase);

        log.debug("Presenter started, console mode = {}", consoleMode);

        if (consoleMode) {
            start();
        }
    }

    private void start() {
        int choice;

        do {
            view.showMenu();
            choice = view.readNumber();

            switch (choice) {
                case 1 -> showAllLegoSets();
                case 2 -> filterLegoSets();
                case 3 -> showAllLegoPieces();
                case 4 -> filterLegoPieces();
                case 0 -> view.showMessage("Goodbye!");
                default -> view.showMessage("Invalid choice.");
            }
        } while (choice != 0);
    }

    private void showAllLegoSets() {
        view.showLegoSets(
                "All LEGO sets",
                legoSetService.getAllLegoSets()
        );
    }

    private void filterLegoSets() {
        int minimumPieces;

        do {
            view.prompt("Minimum number of pieces: ");
            minimumPieces = view.readNumber();

            if (minimumPieces < 0) {
                view.showMessage("Please enter zero or a positive number.");
            }
        } while (minimumPieces < 0);

        view.showLegoSets(
                "LEGO sets with at least " + minimumPieces + " pieces",
                legoSetService.getLegoSetsWithMinimumPieces(minimumPieces)
        );
    }

    private void showAllLegoPieces() {
        view.showLegoPieces(
                "All LEGO pieces",
                legoPieceService.getAllLegoPieces()
        );
    }

    private void filterLegoPieces() {
        view.prompt("Enter part of a name or leave blank: ");
        String name = view.readInput();

        view.prompt(
                "Enter a material (PLASTIC, RUBBER or METAL) or leave blank: "
        );
        String material = view.readInput();

        view.showLegoPieces(
                "Matching LEGO pieces",
                legoPieceService.searchLegoPieces(name, material)
        );
    }
}