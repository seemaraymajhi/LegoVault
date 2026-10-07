package be.kdg.legoproject.service;

import be.kdg.legoproject.domain.LegoPiece;
import be.kdg.legoproject.repository.LegoPieceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultLegoPieceService implements LegoPieceService {

    private final LegoPieceRepository legoPieceRepository;

    public DefaultLegoPieceService(LegoPieceRepository legoPieceRepository) {
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
                .filter(piece ->
                        name.isBlank()
                                || piece.getName()
                                .toLowerCase()
                                .contains(name.toLowerCase()))
                .filter(piece ->
                        material.isBlank()
                                || piece.getMaterial()
                                .name()
                                .equalsIgnoreCase(material))
                .toList();
    }
}