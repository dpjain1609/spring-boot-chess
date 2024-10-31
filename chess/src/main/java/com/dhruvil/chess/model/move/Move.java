package com.dhruvil.chess.model.move;

import com.dhruvil.chess.model.board.Board;
import com.dhruvil.chess.model.constant.ChessConstants;
import com.dhruvil.chess.model.piece.*;
import com.dhruvil.chess.model.tile.EmptyTile;
import com.dhruvil.chess.model.tile.OccupiedTile;
import com.dhruvil.chess.model.tile.Tile;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public abstract class Move {
    protected Integer origin;
    protected Integer destination;
    protected Piece piece;

    public Board executeMove(Board board) {
        List<Tile> newBoard = new ArrayList<>();
        for(int i = 0; i < ChessConstants.TILES_ON_BOARD; i++){
            if(i == this.origin){
                newBoard.add(new EmptyTile(i));
            } else if(i == this.destination){
                Piece transitionedPiece = getTransitionedPiece(this.piece, this.destination);
                newBoard.add(new OccupiedTile(i, transitionedPiece));
            } else{
                newBoard.add(board.getTile(i));
            }
        }

        return new Board(newBoard);
    }

    private Piece getTransitionedPiece(Piece piece, Integer destination){
        Piece transitionedPiece;
        if(piece instanceof Pawn){
            transitionedPiece = new Pawn(destination, piece.getColor(), Boolean.FALSE);
        } else if(piece instanceof Knight){
            transitionedPiece = new Knight(destination, piece.getColor(), Boolean.FALSE);
        } else if(piece instanceof Bishop){
            transitionedPiece = new Bishop(destination, piece.getColor(), Boolean.FALSE);
        } else if(piece instanceof Rook){
            transitionedPiece = new Rook(destination, piece.getColor(), Boolean.FALSE);
        } else if(piece instanceof Queen){
            transitionedPiece = new Queen(destination, piece.getColor(), Boolean.FALSE);
        } else if(piece instanceof King){
            transitionedPiece = new King(destination, piece.getColor(), Boolean.FALSE);
        } else{
            //TODO: make a custom exception and throw it here
            throw new RuntimeException();
        }
        return transitionedPiece;
    }
}
