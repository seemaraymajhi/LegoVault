package be.kdg.legoproject.view;

import be.kdg.legoproject.repository.DataFactory;
import be.kdg.legoproject.service.DefaultLegoPieceService;
import be.kdg.legoproject.service.DefaultLegoSetService;
import be.kdg.legoproject.service.LegoPieceService;
import be.kdg.legoproject.service.LegoSetService;

import java.util.Scanner;

public class View {

    private final LegoSetService legoSetService =
            new DefaultLegoSetService();

    private final LegoPieceService legoPieceService =
            new DefaultLegoPieceService();
    private final Scanner scanner = new Scanner(System.in);

    public void show() {
        DataFactory.seed();

        int choice;

        do {
            System.out.println();
            System.out.println("What would you like to do?");
            System.out.println("==========================");
            System.out.println("0) Quit");
            System.out.println("1) Show all LEGO sets");
            System.out.println("2) Show LEGO sets with at least X pieces");
            System.out.println("3) Show all LEGO pieces");
            System.out.println("4) Show LEGO pieces by name and/or material");
            System.out.print("Choice (0-4): ");

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> showAllLegoSets();
                case 2 -> filterLegoSets();
                case 3 -> showAllLegoPieces();
                case 4 -> filterLegoPieces();
                case 0 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }

    private void showAllLegoSets() {
        System.out.println();
        System.out.println("All LEGO sets");
        System.out.println("=============");

        legoSetService.getAllLegoSets()
                .forEach(System.out::println);
    }

    private void filterLegoSets() {
        System.out.println();
        System.out.print("Minimum number of pieces: ");

        int minimumPieces = Integer.parseInt(scanner.nextLine());

        legoSetService.getLegoSetsWithMinimumPieces(minimumPieces)
                .forEach(System.out::println);
    }

    private void showAllLegoPieces() {
        System.out.println();
        System.out.println("All LEGO pieces");
        System.out.println("===============");

        legoPieceService.getAllLegoPieces()
                .forEach(System.out::println);
    }

    private void filterLegoPieces() {
        System.out.println();
        System.out.print("Enter part of a name or leave blank: ");
        String name = scanner.nextLine();

        System.out.print(
                "Enter a material (PLASTIC, RUBBER or METAL) or leave blank: ");
        String material = scanner.nextLine();

        legoPieceService.searchLegoPieces(name, material)
                .forEach(System.out::println);
    }
}