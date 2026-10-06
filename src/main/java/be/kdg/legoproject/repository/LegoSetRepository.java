package be.kdg.legoproject.repository;

import be.kdg.legoproject.domain.LegoSet;

import java.util.List;

public interface LegoSetRepository {

    List<LegoSet> getAll();

    void add(LegoSet legoSet);
}