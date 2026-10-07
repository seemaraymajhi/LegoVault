package be.kdg.legoproject.repository;

import be.kdg.legoproject.domain.LegoSet;
import org.springframework.stereotype.Repository;

import java.util.List;

// DATA ACCESS LAYER: in-memory implementation that reads the lists
// filled by DataFactory.
@Repository
public class InMemoryLegoSetRepository implements LegoSetRepository {

    @Override
    public List<LegoSet> getAll() {
        // This repository uses the seeded in-memory list instead of a database.
        return DataFactory.legoSets;
    }

    @Override
    public void add(LegoSet legoSet) {
        DataFactory.legoSets.add(legoSet);
    }
}
