package com.dhruvil.chess.model.move;

import com.dhruvil.chess.model.piece.Piece;
import lombok.Getter;

@Getter
public class AttackMove extends Move{
    private final Piece attackedPiece;

    public AttackMove(Integer origin, Integer destination, Piece piece, Piece attackedPiece) {
        super(origin, destination, piece);
        this.attackedPiece = attackedPiece;
    }

}
