package be.kdg.legoproject.presentation;

import be.kdg.legoproject.service.LegoPieceService;
import be.kdg.legoproject.service.LegoSetService;
import be.kdg.legoproject.view.View;

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

        do {
            view.showMenu();
            choice = Integer.parseInt(view.readInput());

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
        view.showLegoSets(legoSetService.getAllLegoSets());
    }

    private void filterLegoSets() {
        view.prompt("Minimum number of pieces: ");

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

        view.showLegoPieces(
                legoPieceService.searchLegoPieces(name, material)
        );
    }
}