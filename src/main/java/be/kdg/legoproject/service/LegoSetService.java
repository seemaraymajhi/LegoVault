package be.kdg.legoproject.service;

import be.kdg.legoproject.domain.LegoSet;

import java.util.List;

// Business layer contract for LEGO sets.
// The Presenter only knows this interface, not DefaultLegoSetService.
// That is loose coupling: the implementation can change without touching the Presenter.
public interface LegoSetService {

    // Returns every LEGO set.
    List<LegoSet> getAllLegoSets();

    // Returns only sets with at least the given number of pieces.
    // Example: 5000 -> Millennium Falcon, Eiffel Tower, Hogwarts Castle.
    List<LegoSet> getLegoSetsWithMinimumPieces(int minimumPieces);
}