package be.kdg.legoproject.service;

import be.kdg.legoproject.domain.LegoSet;

import java.util.List;

public interface LegoSetService {

    List<LegoSet> getAllLegoSets();

    List<LegoSet> getLegoSetsWithMinimumPieces(int minimumPieces);
}