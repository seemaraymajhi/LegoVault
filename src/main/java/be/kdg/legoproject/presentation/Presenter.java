package be.kdg.legoproject.presentation;

import be.kdg.legoproject.service.LegoPieceService;
import be.kdg.legoproject.service.LegoSetService;
import be.kdg.legoproject.view.View;

// PRESENTATION LAYER (Presenter): contains the menu logic, asks the services
// for data and tells the View what to show.
public class Presenter {

    private final View view;
    private final LegoSetService legoSetService;
    private final LegoPieceService legoPieceService;

    public Presenter(
            View view,
            LegoSetService legoSetService,
            LegoPieceService legoPieceService) {

        this.view = view;
        this.legoSetService = legoSetService;
        this.legoPieceService = legoPieceService;
    }

    public void start() {
        int choice;

        // Keep showing the menu until the user chooses 0.
        do {
            view.showMenu();
            choice = Integer.parseInt(view.readInput());

            // The Presenter translates a menu choice into a specific action.
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
        // Ask the service for data, then pass the result to the View for output.
        view.showLegoSets(legoSetService.getAllLegoSets());
    }

    private void filterLegoSets() {
        view.prompt("Minimum number of pieces: ");

        // Console input is text, so it must be converted before filtering.
        int minimumPieces = Integer.parseInt(view.readInput());

        view.showLegoSets(
                legoSetService.getLegoSetsWithMinimumPieces(minimumPieces)
        );
    }

    private void showAllLegoPieces() {
        view.showLegoPieces(legoPieceService.getAllLegoPieces());
    }

    private void filterLegoPieces() {
        view.prompt("Enter part of a name or leave blank: ");
        String name = view.readInput();

        view.prompt(
                "Enter a material (PLASTIC, RUBBER or METAL) or leave blank: "
        );
        String material = view.readInput();

        // Blank values are allowed; the service decides which filters to apply.
        view.showLegoPieces(
                legoPieceService.searchLegoPieces(name, material)
        );
    }
}
