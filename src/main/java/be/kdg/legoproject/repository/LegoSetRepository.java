package be.kdg.legoproject.repository;

import be.kdg.legoproject.domain.LegoSet;

import java.util.List;

public class LegoSetRepository {

    public List<LegoSet> getAll() {
        return DataFactory.legoSets;
    }

    public void add(LegoSet legoSet) {
        DataFactory.legoSets.add(legoSet);
    }
}