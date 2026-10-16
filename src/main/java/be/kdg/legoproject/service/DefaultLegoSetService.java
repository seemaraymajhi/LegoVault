package be.kdg.legoproject.service;

import be.kdg.legoproject.domain.LegoPiece;
import be.kdg.legoproject.domain.LegoSet;
import be.kdg.legoproject.repository.LegoPieceRepository;
import be.kdg.legoproject.repository.LegoSetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// BUSINESS LAYER: applies LEGO set filtering and business rules,
// using the repositories to retrieve and store the data.
@Service
public class DefaultLegoSetService implements LegoSetService {

    private final LegoSetRepository legoSetRepository;
    private final LegoPieceRepository legoPieceRepository;

    public DefaultLegoSetService(
            LegoSetRepository legoSetRepository,
            LegoPieceRepository legoPieceRepository
    ) {
        // Spring injects the repository implementations marked with @Repository.
        this.legoSetRepository = legoSetRepository;
        this.legoPieceRepository = legoPieceRepository;
    }

    @Override
    public List<LegoSet> getAllLegoSets() {
        return legoSetRepository.getAll();
    }

    @Override
    public List<LegoSet> getLegoSetsWithMinimumPieces(
            int minimumPieces
    ) {
        // Stream through all sets, keep matching sets, and collect a new list.
        return legoSetRepository.getAll()
                .stream()
                .filter(legoSet -> legoSet.getPieceCount() >= minimumPieces)
                .toList();
    }

    @Override
    public void addLegoSet(
            LegoSet legoSet,
            String pieceName
    ) {
        // 1. Find the chosen piece; fail clearly if it doesn't exist.
        LegoPiece selectedPiece = legoPieceRepository.getAll()
                .stream()
                .filter(piece ->
                        piece.getName().equals(pieceName)
                )
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Unknown LEGO piece: " + pieceName
                        )
                );

        // 2. Link set and piece (also updates the piece's list of sets).
        legoSet.addLegoPiece(selectedPiece);

        // 3. Save the new set.
        legoSetRepository.add(legoSet);
    }
}