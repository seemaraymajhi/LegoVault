package be.kdg.legoproject.service;

import be.kdg.legoproject.domain.LegoSet;
import be.kdg.legoproject.repository.LegoSetRepository;

import java.util.List;

public class DefaultLegoSetService implements LegoSetService {

    private final LegoSetRepository legoSetRepository;

    public DefaultLegoSetService(LegoSetRepository legoSetRepository) {
        this.legoSetRepository = legoSetRepository;
    }

    @Override
    public List<LegoSet> getAllLegoSets() {
        return legoSetRepository.getAll();
    }

    @Override
    public List<LegoSet> getLegoSetsWithMinimumPieces(int minimumPieces) {
        return legoSetRepository.getAll()
                .stream()
                .filter(legoSet -> legoSet.getPieceCount() >= minimumPieces)
                .toList();
    }
}