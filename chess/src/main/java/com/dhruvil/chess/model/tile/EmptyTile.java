package com.dhruvil.chess.model.tile;

public class EmptyTile extends Tile{

    public EmptyTile(Integer tileNumber) {
        super(tileNumber, null);
    }

    @Override
    public Boolean isOccupied() {
        return Boolean.FALSE;
    }

    @Override
    public String toString() {
        return "-";
    }
}
