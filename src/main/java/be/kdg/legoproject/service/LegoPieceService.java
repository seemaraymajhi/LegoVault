package be.kdg.legoproject.service;

import be.kdg.legoproject.domain.LegoPiece;
import be.kdg.legoproject.domain.Material;
import be.kdg.legoproject.repository.LegoPieceRepository;

import java.util.List;

public class LegoPieceService {

    private final LegoPieceRepository legoPieceRepository =
            new LegoPieceRepository();

    public List<LegoPiece> getAllLegoPieces() {
        return legoPieceRepository.getAll();
    }

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