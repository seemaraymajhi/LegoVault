package be.kdg.legoproject.repository;

import be.kdg.legoproject.domain.LegoSet;
import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

// DATA ACCESS LAYER: in-memory implementation that reads the lists
// filled by DataFactory.
@Repository
public class InMemoryLegoSetRepository implements LegoSetRepository {

    private static final Logger log =
            LoggerFactory.getLogger(InMemoryLegoSetRepository.class);


    @Override
    public List<LegoSet> getAll() {
        // This repository uses the seeded in-memory list instead of a database.
        log.debug(
                "Reading all LEGO sets from memory, count={}",
                DataFactory.legoSets.size()
        );
        return DataFactory.legoSets;
    }

    @Override
    public void add(LegoSet legoSet) {
        log.debug(
                "Adding LEGO set '{}' to memory",
                legoSet.getName()
        );
        DataFactory.legoSets.add(legoSet);
    }
}
