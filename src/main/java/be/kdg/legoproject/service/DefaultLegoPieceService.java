package be.kdg.legoproject.service;

import be.kdg.legoproject.domain.LegoPiece;
import be.kdg.legoproject.repository.LegoPieceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// BUSINESS LAYER: applies LEGO piece filtering and business rules,
// using the repository to retrieve the data.

@Service
public class DefaultLegoPieceService implements LegoPieceService {

    private final LegoPieceRepository legoPieceRepository;

    public DefaultLegoPieceService(LegoPieceRepository legoPieceRepository) {
        // Spring injects the repository implementation marked with @Repository.
        this.legoPieceRepository = legoPieceRepository;
    }

    @Override
    public List<LegoPiece> getAllLegoPieces() {
        return legoPieceRepository.getAll();
    }

    @Override
    public List<LegoPiece> searchLegoPieces(String name, String material) {
        return legoPieceRepository.getAll()
                .stream()
                // A blank name skips this filter; otherwise compare without
                // caring about uppercase/lowercase letters.
                .filter(piece ->
                        name.isBlank()
                                || piece.getName()
                                .toLowerCase()
                                .contains(name.toLowerCase()))
                // Material must match completely (for example, PLASTIC).
                // A blank material skips this filter as well.
                .filter(piece ->
                        material.isBlank()
                                || piece.getMaterial()
                                .name()
                                .equalsIgnoreCase(material))
                .toList();
    }

    // Stores a new LEGO piece through the repository.
    // The service doesn't save anything itself;
    // it passes the piece to the data layer.
    @Override
    public void addLegoPiece(LegoPiece legoPiece) {
        legoPieceRepository.add(legoPiece);
    }
}
