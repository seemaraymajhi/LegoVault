package be.kdg.legoproject.repository;

import be.kdg.legoproject.domain.LegoPiece;

import java.util.List;

public class InMemoryLegoPieceRepository implements LegoPieceRepository {

    @Override
    public List<LegoPiece> getAll() {
        return DataFactory.legoPieces;
    }

    @Override
    public void add(LegoPiece legoPiece) {
        DataFactory.legoPieces.add(legoPiece);
    }
}