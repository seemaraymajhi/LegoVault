package be.kdg.legoproject;

import java.util.Scanner;

public class ConsoleApp {

    private final Scanner scanner = new Scanner(System.in);

    public void run() {
        DataFactory.seed();
        int choice = -1;
        while (choice != 0) {
            printMenu();
            choice = readInt("Choice (0-4): ");
            switch (choice) {
                case 0 -> System.out.println("Bye!");
                case 1 -> showAllLegoSets();
                case 2 -> showLegoSetsByMinPieceCount();
                case 3 -> showAllLegoPieces();
                case 4 -> showLegoPiecesByNameAndOrMaterial();
                default -> System.out.println("Unknown choice, try again.");
            }
            System.out.println();
        }
    }

    private void printMenu() {
        System.out.println("What would you like to do?");
        System.out.println("==========================");
        System.out.println("0) Quit");
        System.out.println("1) Show all LEGO sets");
        System.out.println("2) Show LEGO sets with at least X pieces");
        System.out.println("3) Show all LEGO pieces");
        System.out.println("4) Show LEGO pieces by name and/or material");
    }

    // option 1: show all of first entity
    private void showAllLegoSets() {
        System.out.println();
        System.out.println("All LEGO sets");
        System.out.println("=============");
        DataFactory.legoSets.stream()
                .map(Object::toString)
                .forEach(System.out::println);
    }

    // option 2: first entity, 1 MANDATORY criterion, non-equality filter on an int
    private void showLegoSetsByMinPieceCount() {
        int minPieces = readInt("Minimum piece count: ");
        System.out.println();
        System.out.println("LEGO sets with at least " + minPieces + " pieces");
        System.out.println("=================================");
        DataFactory.legoSets.stream()
                .filter(s -> s.getPieceCount() >= minPieces)
                .map(Object::toString)
                .forEach(System.out::println);
    }

    // option 3: show all of second entity
    private void showAllLegoPieces() {
        System.out.println();
        System.out.println("All LEGO pieces");
        System.out.println("===============");
        DataFactory.legoPieces.stream()
                .map(Object::toString)
                .forEach(System.out::println);
    }

    // option 4: second entity, 2 OPTIONAL criteria (name = String contains, material = enum equality)
    private void showLegoPiecesByNameAndOrMaterial() {
        System.out.print("Enter (part of) a name or leave blank: ");
        String nameFilter = scanner.nextLine().trim();

        System.out.print("Enter a material (PLASTIC/RUBBER/METAL) or leave blank: ");
        String materialFilter = scanner.nextLine().trim();

        Material material = null;
        if (!materialFilter.isEmpty()) {
            try {
                material = Material.valueOf(materialFilter.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Unknown material: " + materialFilter);
                return;
            }
        }
        final Material selectedMaterial = material;

        System.out.println();
        System.out.println("Matching LEGO pieces");
        System.out.println("=====================");
        DataFactory.legoPieces.stream()
                .filter(p -> nameFilter.isEmpty()
                        || p.getName().toLowerCase().contains(nameFilter.toLowerCase()))
                .filter(p -> selectedMaterial == null || p.getMaterial() == selectedMaterial)
                .map(Object::toString)
                .forEach(System.out::println);
    }

    private int readInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            scanner.next(); // discard invalid token
            System.out.print("Please enter a number - " + prompt);
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // consume trailing newline
        return value;
    }

    public static void main(String[] args) {
        new ConsoleApp().run();
    }
}
