package com.dhruvil.chess.model.tile;

import com.dhruvil.chess.model.piece.Piece;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Tile {
    protected final Integer tileNumber;
    protected final Piece piece;

    public abstract Boolean isOccupied();
}
