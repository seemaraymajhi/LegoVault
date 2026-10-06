package be.kdg.legoproject.service;

import be.kdg.legoproject.domain.LegoPiece;

import java.util.List;

public interface LegoPieceService {

    List<LegoPiece> getAllLegoPieces();

    List<LegoPiece> searchLegoPieces(String name, String material);
}