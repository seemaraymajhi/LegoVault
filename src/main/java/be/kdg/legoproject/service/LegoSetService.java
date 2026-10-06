package be.kdg.legoproject.service;

import be.kdg.legoproject.domain.LegoSet;
import be.kdg.legoproject.repository.LegoSetRepository;

import java.util.List;

public class LegoSetService {

    private final LegoSetRepository legoSetRepository =
            new LegoSetRepository();

    public List<LegoSet> getAllLegoSets() {
        return legoSetRepository.getAll();
    }

    public List<LegoSet> getLegoSetsWithMinimumPieces(int minimumPieces) {
        return legoSetRepository.getAll()
                .stream()
                .filter(legoSet -> legoSet.getPieceCount() >= minimumPieces)
                .toList();
    }
}