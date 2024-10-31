package com.dhruvil.chess.model.piece;

import com.dhruvil.chess.model.board.Board;
import com.dhruvil.chess.model.color.Color;
import com.dhruvil.chess.model.move.AttackMove;
import com.dhruvil.chess.model.move.Move;
import com.dhruvil.chess.model.move.NormalMove;
import com.dhruvil.chess.model.tile.Tile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.dhruvil.chess.model.constant.ChessConstants.isOnEighthFile;
import static com.dhruvil.chess.model.constant.ChessConstants.isOnFirstFile;
import static com.dhruvil.chess.model.utils.ChessUtils.isValidTile;

public class Rook extends Piece{
    private final Integer[] moveVectors = new Integer[]{-8, -1, 1, 8};

    public Rook(Integer position, Color color, Boolean isFirstMove) {
        super(position, color, isFirstMove);
    }

    @Override
    public List<Move> getLegalMoves(Board board) {
        List<Move> legalMoves = new ArrayList<>();

        for(Integer moveVector : moveVectors){
            if(isLegalMove(this.position, moveVector)){
                Integer nextMove = this.position + moveVector;
                Tile destinationTile = board.getTile(nextMove);
                
                if(destinationTile.isOccupied()){
                    if(!destinationTile.getPiece().getColor().equals(this.color)){
                        legalMoves.add(new AttackMove(this.position, nextMove, this, destinationTile.getPiece()));
                    }
                } else{
                    // check for subsequent vectors
                    legalMoves.add(new NormalMove(this.position, nextMove, this));
                    nextMove += moveVector;
                    destinationTile = board.getTile(nextMove);
                    while(isLegalMove(this.position, nextMove)){
                        if(destinationTile.isOccupied()){
                            if(!destinationTile.getPiece().getColor().equals(this.color)){
                                legalMoves.add(new AttackMove(this.position, nextMove, this, destinationTile.getPiece()));
                            }
                        } else{
                            legalMoves.add(new NormalMove(this.position, nextMove, this));
                            nextMove += moveVector;
                        }
                    }
                }
            }
        }

        return Collections.unmodifiableList(legalMoves);
    }

    private boolean isLegalMove(Integer currentPosition, Integer moveVector){
        return (isValidTile(currentPosition + moveVector) &&
                !(isOnFirstFile[currentPosition] && (moveVector == -1) ||
                isOnEighthFile[currentPosition] && (moveVector == 1)));
    }

    @Override
    public String toString() {
        return this.color.equals(Color.WHITE) ? "R" : "r";
    }

}
