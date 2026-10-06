package be.kdg.legoproject.repository;

import be.kdg.legoproject.domain.LegoPiece;

import java.util.List;

public interface LegoPieceRepository {

    List<LegoPiece> getAll();

    void add(LegoPiece legoPiece);
}