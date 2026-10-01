package be.kdg.legoproject;

import java.util.Scanner;

public class ConsoleApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        DataFactory.seed();

        do {
            System.out.println("What would you like to do?");
            System.out.println("==========================");
            System.out.println("0) Quit");
            System.out.println("1) Show all LEGO sets");
            System.out.println("2) Show LEGO sets with at least X pieces");
            System.out.println("3) Show all LEGO pieces");
            System.out.println("4) Show LEGO pieces by name and/or material");
            System.out.print("Choice (0-4): ");

            choice = Integer.parseInt(scanner.nextLine().trim());
            System.out.println();

            switch (choice) {
                case 0:
                    System.out.println("Goodbye!");
                    break;

                case 1:
                    System.out.println("All LEGO sets");
                    System.out.println("=============");

                    DataFactory.legoSets.forEach(System.out::println);
                    break;

                case 2:
                    System.out.print("Minimum number of pieces: ");
                    int minimumPieces = Integer.parseInt(scanner.nextLine().trim());

                    System.out.println("LEGO sets with at least " + minimumPieces + " pieces");
                    System.out.println("=================================");

                    DataFactory.legoSets.stream()
                            .filter(legoSet -> legoSet.getPieceCount() >= minimumPieces)
                            .forEach(System.out::println);
                    break;

                case 3:
                    System.out.println("All LEGO pieces");
                    System.out.println("===============");

                    DataFactory.legoPieces.forEach(System.out::println);
                    break;

                case 4:
                    System.out.print("Enter part of a name or leave blank: ");
                    String name = scanner.nextLine().trim().toLowerCase();

                    System.out.print("Enter a material (PLASTIC, RUBBER or METAL) or leave blank: ");
                    String material = scanner.nextLine().trim();

                    System.out.println("Matching LEGO pieces");
                    System.out.println("====================");

                    DataFactory.legoPieces.stream()
                            .filter(legoPiece -> name.isEmpty()
                                    || legoPiece.getName().toLowerCase().contains(name))
                            .filter(legoPiece -> material.isEmpty()
                                    || legoPiece.getMaterial().name().equalsIgnoreCase(material))
                            .forEach(System.out::println);
                    break;

                default:
                    System.out.println("Please choose a number from 0 to 4.");
            }

            System.out.println();
        } while (choice != 0);

        scanner.close();
    }
}