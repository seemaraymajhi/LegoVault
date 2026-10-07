package be.kdg.legoproject.service;

import be.kdg.legoproject.domain.LegoSet;
import be.kdg.legoproject.repository.LegoSetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// BUSINESS LAYER: applies LEGO set filtering and business rules,
// using the repository to retrieve the data.

@Service
public class DefaultLegoSetService implements LegoSetService {

    private final LegoSetRepository legoSetRepository;

    public DefaultLegoSetService(LegoSetRepository legoSetRepository) {
        // Spring injects the repository implementation marked with @Repository.
        this.legoSetRepository = legoSetRepository;
    }

    @Override
    public List<LegoSet> getAllLegoSets() {
        return legoSetRepository.getAll();
    }

    @Override
    public List<LegoSet> getLegoSetsWithMinimumPieces(int minimumPieces) {
        // Stream through all sets, keep matching sets, and collect a new list.
        return legoSetRepository.getAll()
                .stream()
                .filter(legoSet -> legoSet.getPieceCount() >= minimumPieces)
                .toList();
    }
}
