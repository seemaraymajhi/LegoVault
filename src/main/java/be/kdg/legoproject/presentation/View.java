package be.kdg.legoproject.presentation;

import be.kdg.legoproject.domain.LegoPiece;
import be.kdg.legoproject.domain.LegoSet;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

// Handles console input and output only.
@Component
public class View {

    private final Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println("==========================");
        System.out.println("0) Quit");
        System.out.println("1) Show all LEGO sets");
        System.out.println("2) Show LEGO sets with at least X pieces");
        System.out.println("3) Show all LEGO pieces");
        System.out.println("4) Show LEGO pieces by name and/or material");
        System.out.print("Choice (0-4): ");
    }

    public String readInput() {
        return scanner.nextLine().trim();
    }

    public int readNumber() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException exception) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }

    public void prompt(String message) {
        System.out.print(message);
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showLegoSets(String title, List<LegoSet> legoSets) {
        showTitle(title);

        if (legoSets.isEmpty()) {
            showMessage("No LEGO sets found.");
            return;
        }

        legoSets.forEach(System.out::println);
    }

    public void showLegoPieces(String title, List<LegoPiece> legoPieces) {
        showTitle(title);

        if (legoPieces.isEmpty()) {
            showMessage("No LEGO pieces found.");
            return;
        }

        legoPieces.forEach(System.out::println);
    }


    private void showTitle(String title) {
        System.out.println();
        System.out.println(title);
        System.out.println("=".repeat(title.length()));
    }
}