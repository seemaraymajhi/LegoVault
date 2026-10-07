package be.kdg.legoproject;

import be.kdg.legoproject.repository.InMemoryLegoPieceRepository;
import be.kdg.legoproject.repository.InMemoryLegoSetRepository;
import be.kdg.legoproject.repository.LegoPieceRepository;
import be.kdg.legoproject.repository.LegoSetRepository;
import be.kdg.legoproject.service.DefaultLegoPieceService;
import be.kdg.legoproject.service.DefaultLegoSetService;
import be.kdg.legoproject.service.LegoPieceService;
import be.kdg.legoproject.service.LegoSetService;
import be.kdg.legoproject.view.View;

public class ConsoleApp {

    public static void main(String[] args) {

        LegoSetRepository legoSetRepository =
                new InMemoryLegoSetRepository();

        LegoPieceRepository legoPieceRepository =
                new InMemoryLegoPieceRepository();

        LegoSetService legoSetService =
                new DefaultLegoSetService(legoSetRepository);

        LegoPieceService legoPieceService =
                new DefaultLegoPieceService(legoPieceRepository);

        View view = new View(legoSetService, legoPieceService);

        view.show();
    }
}