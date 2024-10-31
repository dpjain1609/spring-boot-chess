package com.dhruvil.chess.model.piece;

import com.dhruvil.chess.model.board.Board;
import com.dhruvil.chess.model.color.Color;
import com.dhruvil.chess.model.constant.ChessConstants;
import com.dhruvil.chess.model.move.AttackMove;
import com.dhruvil.chess.model.move.Move;
import com.dhruvil.chess.model.move.NormalMove;
import com.dhruvil.chess.model.tile.Tile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.dhruvil.chess.model.utils.ChessUtils.isValidTile;

public class Knight extends Piece{
    private final Integer[] destinationTiles = new Integer[]{-17, -15, -10, -6, 6, 10, 15, 17};

    public Knight(Integer position, Color color, Boolean isFirstMove) {
        super(position, color, isFirstMove);
    }

    @Override
    public List<Move> getLegalMoves(Board board) {
        List<Move> legalMoves = new ArrayList<>();

        for(Integer move : destinationTiles){
            if(isLegalMove(this.position, move)){
                Integer nextMove = this.position + move;
                Tile destinationTile = board.getTile(nextMove);
                if(destinationTile.isOccupied()){
                    if(!destinationTile.getPiece().getColor().equals(this.color)){
                        legalMoves.add(new AttackMove(this.position, nextMove, this, destinationTile.getPiece()));
                    }
                } else {
                    legalMoves.add(new NormalMove(this.position, nextMove, this));
                }
            }
        }

        return Collections.unmodifiableList(legalMoves);
    }

    private Boolean isLegalMove(Integer currentPosition, Integer move){
        return isValidTile(currentPosition + move) &&
            !(
                ChessConstants.isOnFirstFile[currentPosition] && (move == -17 || move == -10 || move == 6 || move == 15) ||
                ChessConstants.isOnSecondFile[currentPosition] && (move == -10 || move == 6) ||
                ChessConstants.isOnSeventhFile[currentPosition] && (move == -6 || move == 10) ||
                ChessConstants.isOnEighthFile[currentPosition] && (move == -15 || move == -6 || move == 10 || move == 17)
            );
    }

    @Override
    public String toString() {
        return this.color.equals(Color.WHITE) ? "N" : "n";
    }
}
