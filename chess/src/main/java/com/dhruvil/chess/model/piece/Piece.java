package com.dhruvil.chess.model.piece;

import com.dhruvil.chess.model.board.Board;
import com.dhruvil.chess.model.color.Color;
import com.dhruvil.chess.model.move.Move;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public abstract class Piece {
    protected final Integer position;
    protected final Color color;
    protected final Boolean isFirstMove;

    public abstract List<Move> getLegalMoves(Board board);
}
