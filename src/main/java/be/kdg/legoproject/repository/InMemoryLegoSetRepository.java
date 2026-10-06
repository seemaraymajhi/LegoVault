package be.kdg.legoproject.repository;

import be.kdg.legoproject.domain.LegoSet;

import java.util.List;

public class InMemoryLegoSetRepository implements LegoSetRepository {

    @Override
    public List<LegoSet> getAll() {
        return DataFactory.legoSets;
    }

    @Override
    public void add(LegoSet legoSet) {
        DataFactory.legoSets.add(legoSet);
    }
}