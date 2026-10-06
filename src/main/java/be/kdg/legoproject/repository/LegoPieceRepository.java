package be.kdg.legoproject.repository;

import be.kdg.legoproject.domain.LegoPiece;

import java.util.List;

public class LegoPieceRepository {

    public List<LegoPiece> getAll() {
        return DataFactory.legoPieces;
    }

    public void add(LegoPiece legoPiece) {
        DataFactory.legoPieces.add(legoPiece);
    }
}