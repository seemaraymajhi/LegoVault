package be.kdg.legoproject.repository;

import be.kdg.legoproject.domain.LegoPiece;

import java.util.List;

// Data access layer contract for LEGO pieces.
// The service depends on this interface, not on the in-memory implementation.
public interface LegoPieceRepository {

    // Returns all stored LEGO pieces.
    List<LegoPiece> getAll();

    // Stores a new LEGO piece.
    void add(LegoPiece legoPiece);
}