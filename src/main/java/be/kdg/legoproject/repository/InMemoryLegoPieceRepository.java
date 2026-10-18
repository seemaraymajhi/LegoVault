package be.kdg.legoproject.repository;

import be.kdg.legoproject.domain.LegoPiece;
import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

// DATA ACCESS LAYER: in-memory implementation that reads the lists
// filled by DataFactory.
@Repository
public class InMemoryLegoPieceRepository implements LegoPieceRepository {

    private static final Logger log =
            LoggerFactory.getLogger(InMemoryLegoPieceRepository.class);

    @Override
    public List<LegoPiece> getAll() {
        // This repository uses the seeded in-memory list instead of a database.
        log.debug(
                "Reading all LEGO pieces from memory, count={}",
                DataFactory.legoPieces.size()
        );
        return DataFactory.legoPieces;
    }

    @Override
    public void add(LegoPiece legoPiece) {
        log.debug(
                "Adding LEGO piece '{}' to memory",
                legoPiece.getName()
        );
        DataFactory.legoPieces.add(legoPiece);
    }
}
