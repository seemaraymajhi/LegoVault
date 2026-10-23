package be.kdg.legoproject.service;

import be.kdg.legoproject.domain.LegoSet;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

// Business layer contract for LEGO sets.
// The Presenter only knows this interface, not DefaultLegoSetService.
// That is loose coupling: the implementation can change without touching the Presenter.
public interface LegoSetService {

    // Returns every LEGO set.
    List<LegoSet> getAllLegoSets();

    // Returns only sets with at least the given number of pieces.
    // Example: 5000 -> Millennium Falcon, Eiffel Tower, Hogwarts Castle.
    List<LegoSet> getLegoSetsWithMinimumPieces(
            int minimumPieces
    );

    // Returns the LEGO set with the given id, or an empty Optional.
    Optional<LegoSet> getLegoSetById(UUID id);

    // Stores a new LEGO set and connects
    // it to the selected LEGO piece.
    void addLegoSet(
            LegoSet legoSet,
            String pieceName
    );
}