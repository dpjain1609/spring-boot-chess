package com.dhruvil.chess.model.player;

import com.dhruvil.chess.model.board.Board;
import com.dhruvil.chess.model.color.Color;
import com.dhruvil.chess.model.move.Move;

import java.util.List;

public class WhitePlayer extends Player{
    public WhitePlayer(Boolean turn, Board board, List<Move> opponentLegalMoves) {
        super(Color.WHITE, turn, board, opponentLegalMoves);
    }
}
