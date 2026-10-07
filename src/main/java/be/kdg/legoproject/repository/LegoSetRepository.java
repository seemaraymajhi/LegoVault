package be.kdg.legoproject.repository;

import be.kdg.legoproject.domain.LegoSet;

import java.util.List;

// Data access layer contract for LEGO sets.
// Today the data comes from memory (InMemoryLegoSetRepository).
// Later a database version can implement this same interface,
// and the service will not need to change.
public interface LegoSetRepository {

    // Returns all stored LEGO sets.
    List<LegoSet> getAll();

    // Stores a new LEGO set.
    void add(LegoSet legoSet);
}