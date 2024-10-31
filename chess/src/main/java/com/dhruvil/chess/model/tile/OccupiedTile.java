package com.dhruvil.chess.model.tile;

import com.dhruvil.chess.model.piece.Piece;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OccupiedTile extends Tile{
    public OccupiedTile(Integer tileNumber, Piece piece) {
        super(tileNumber, piece);
    }

    @Override
    public Boolean isOccupied() {
        return Boolean.TRUE;
    }

    @Override
    public String toString() {
        return this.piece.toString();
    }
}
