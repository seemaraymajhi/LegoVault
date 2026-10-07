package be.kdg.legoproject.repository;

import be.kdg.legoproject.domain.LegoPiece;
import org.springframework.stereotype.Repository;

import java.util.List;

// DATA ACCESS LAYER: in-memory implementation that reads the lists
// filled by DataFactory.
@Repository
public class InMemoryLegoPieceRepository implements LegoPieceRepository {

    @Override
    public List<LegoPiece> getAll() {
        // This repository uses the seeded in-memory list instead of a database.
        return DataFactory.legoPieces;
    }

    @Override
    public void add(LegoPiece legoPiece) {
        DataFactory.legoPieces.add(legoPiece);
    }
}
