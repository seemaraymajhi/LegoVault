package be.kdg.legoproject.repository;

import be.kdg.legoproject.domain.LegoPiece;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
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