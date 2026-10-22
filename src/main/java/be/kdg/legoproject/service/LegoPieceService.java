package be.kdg.legoproject.service;

import be.kdg.legoproject.domain.LegoPiece;

import java.util.List;

// Business layer contract for LEGO pieces.
// The Presenter depends on this interface;
// Spring injects DefaultLegoPieceService.
public interface LegoPieceService {

    // Returns every LEGO piece.
    List<LegoPiece> getAllLegoPieces();

    // Both filters are optional: pass "" to skip one.
    // Example: ("brick", "") -> all pieces with "brick" in the name.
    // Example: ("", "METAL")  -> all metal pieces.
    List<LegoPiece> searchLegoPieces(String name, String material);

    // Stores a new LEGO piece.
    // Example: addLegoPiece(new LegoPiece
    // ("1x1 Round Plate", "Yellow", Material.PLASTIC))
    void addLegoPiece(LegoPiece legoPiece);
}