package com.dhruvil.chess.model.piece;

import com.dhruvil.chess.model.board.Board;
import com.dhruvil.chess.model.color.Color;
import com.dhruvil.chess.model.constant.ChessConstants;
import com.dhruvil.chess.model.move.AttackMove;
import com.dhruvil.chess.model.move.Move;
import com.dhruvil.chess.model.move.NormalMove;
import com.dhruvil.chess.model.utils.ChessUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class King extends Piece{

    private final Integer[] normalMoves = new Integer[]{-9, -8, -7, -1, 1, 7, 8, 9};

    public King(Integer position, Color color, Boolean isFirstMove) {
        super(position, color, isFirstMove);
    }

    @Override
    public List<Move> getLegalMoves(Board board) {
        List<Move> legalMoves = new ArrayList<>();

        for(Integer move : normalMoves){
            if(isLegalMove(this.position, move)){
                Integer nextMove = this.position + move;
                if(board.getTile(nextMove).isOccupied()){
                    if(!board.getTile(nextMove).getPiece().getColor().equals(this.color)){
                        legalMoves.add(new AttackMove(this.position, nextMove, this, board.getTile(nextMove).getPiece()));
                    }
                } else {
                    legalMoves.add(new NormalMove(this.position, nextMove, this));
                }
            }
        }

        return Collections.unmodifiableList(legalMoves);
    }

    private Boolean isLegalMove(Integer currentPosition, Integer move){
        return ChessUtils.isValidTile(currentPosition + move) &&
            !(
                ChessConstants.isOnFirstFile[currentPosition] && (move == -1 || move == -9) ||
                ChessConstants.isOnEighthFile[currentPosition] && (move == 1 || move == 9)
            );
    }

    @Override
    public String toString() {
        return this.color.equals(Color.WHITE) ? "K" : "k";
    }
}
