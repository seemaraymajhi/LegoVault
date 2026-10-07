package be.kdg.legoproject.view;

import be.kdg.legoproject.domain.LegoPiece;
import be.kdg.legoproject.domain.LegoSet;
import be.kdg.legoproject.presentation.Presenter;
import be.kdg.legoproject.service.LegoPieceService;
import be.kdg.legoproject.service.LegoSetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

// PRESENTATION LAYER (View): handles console input/output
// and starts the Presenter through CommandLineRunner.
@Component
public class View implements CommandLineRunner {

    private final Scanner scanner = new Scanner(System.in);
    private final Presenter presenter;

    public View(LegoSetService legoSetService, LegoPieceService legoPieceService) {
        // Spring supplies both services here. The View then gives them to the
        // Presenter, which controls what should happen after user input.
        this.presenter = new Presenter(this, legoSetService, legoPieceService);
    }

    @Override
    public void run(String... args) {
        // CommandLineRunner.run is called automatically after Spring starts.
        presenter.start();
    }

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
        // nextLine reads the complete line and returns it to the Presenter.
        return scanner.nextLine();
    }

    public void prompt(String message) {
        System.out.print(message);
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showLegoSets(List<LegoSet> legoSets) {
        // println automatically calls toString() on every LegoSet.
        legoSets.forEach(System.out::println);
    }

    public void showLegoPieces(List<LegoPiece> legoPieces) {
        // println automatically calls toString() on every LegoPiece.
        legoPieces.forEach(System.out::println);
    }
}
