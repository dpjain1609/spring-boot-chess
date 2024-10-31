package com.dhruvil.chess.model.move;

import com.dhruvil.chess.model.piece.Piece;

public class NormalMove extends Move{
    public NormalMove(Integer origin, Integer destination, Piece piece) {
        super(origin, destination, piece);
    }
}
