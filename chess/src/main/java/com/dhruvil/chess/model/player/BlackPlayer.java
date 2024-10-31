package com.dhruvil.chess.model.player;

import com.dhruvil.chess.model.board.Board;
import com.dhruvil.chess.model.color.Color;
import com.dhruvil.chess.model.move.Move;

import java.util.List;

public class BlackPlayer extends Player{
    public BlackPlayer(Boolean turn, Board board, List<Move> opponentLegalMoves) {
        super(Color.BLACK, turn, board, opponentLegalMoves);
    }
}
