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

public class Pawn extends Piece{

    private final Integer normalMove = 8;
    private final Integer jumpMove = 16;
    private final Integer[] attackMoves = new Integer[]{7, 9};
    private final Integer[] enPassantMove = new Integer[]{7, 9};

    public Pawn(Integer position, Color color, Boolean isFirstMove) {
        super(position, color, isFirstMove);
    }

    @Override
    public List<Move> getLegalMoves(Board board) {
        List<Move> legalMoves = new ArrayList<>();

        if(isFirstMove &&
                !board.getTile(this.position + (this.normalMove * this.color.direction)).isOccupied() &&
                !board.getTile(this.position + (this.jumpMove * this.color.direction)).isOccupied()){
            legalMoves.add(new NormalMove(this.position, this.position + (jumpMove * this.color.direction), this));
        }

        if(!board.getTile(this.position + (this.normalMove * this.color.direction)).isOccupied()){
            legalMoves.add(new NormalMove(this.position, this.position + (this.normalMove * this.color.direction), this));
        }

        for(Integer move : attackMoves){
            Integer nextMove = this.position + (move * this.color.direction);
            if(isLegalMove(this.position, (this.jumpMove * this.color.direction)) &&
                    board.getTile(nextMove).isOccupied() &&
                    !board.getTile(nextMove).getPiece().getColor().equals(this.color)){
                legalMoves.add(new AttackMove(this.position, nextMove, this, board.getTile(nextMove).getPiece()));
            }
        }

        //TODO: en passant move
        //TODO: promotional move

        return Collections.unmodifiableList(legalMoves);
    }

    private boolean isLegalMove(int currentPosition, int move){
        return ChessUtils.isValidTile(currentPosition + move) &&
                !((ChessConstants.isOnFirstFile[currentPosition] && this.color == Color.WHITE && move == 7) ||
                        ChessConstants.isOnFirstFile[currentPosition] && this.color == Color.BLACK && move == -9 ||
                        ChessConstants.isOnEighthFile[currentPosition] && this.color == Color.WHITE && move == 9 ||
                        ChessConstants.isOnEighthFile[currentPosition] && this.color == Color.BLACK && move == -7);
    }

    @Override
    public String toString() {
        return this.color.equals(Color.WHITE) ? "P" : "p";
    }
}
