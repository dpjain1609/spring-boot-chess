package com.dhruvil.chess.model.player;

import com.dhruvil.chess.model.board.Board;
import com.dhruvil.chess.model.color.Color;
import com.dhruvil.chess.model.constant.ChessConstants;
import com.dhruvil.chess.model.move.Move;
import com.dhruvil.chess.model.piece.King;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public abstract class Player {
    private final Color color;
    private final Boolean turn;
    private final Boolean isInCheck;
    private final Boolean isInCheckMate;
    private final Boolean isInStaleMate;
    private final Board board;
    private final List<Move> playerLegalMoves;
    private final List<Move> opponentLegalMoves;
    private final King king;
    
    public Player(Color color, Boolean turn, Board board, List<Move> opponentLegalMoves){
        this.color = color;
        this.turn = turn;
        this.board = board;
        this.opponentLegalMoves = opponentLegalMoves; 
        this.playerLegalMoves = getAllLegalMoves();
        this.king = getPlayerKing();
        this.isInCheck = calculateIsInCheck();
        this.isInCheckMate = calculateIsInCheckMate();
        this.isInStaleMate = calculateIsInStaleMate();
    }
    
    private List<Move> getAllLegalMoves(){   
        List<Move> legalMoves = new ArrayList<>();
        for(int i = 0; i < ChessConstants.TILES_ON_BOARD; i++){
            if(board.getTile(i).isOccupied() && 
                board.getTile(i).getPiece().getColor().equals(color)){
                legalMoves.addAll(board.getTile(i).getPiece().getLegalMoves(board));
            }
        }
        return legalMoves;
    }

    private King getPlayerKing(){
        for(int i = 0; i < ChessConstants.TILES_ON_BOARD; i++){
            if(board.getTile(i).isOccupied() &&
                board.getTile(i).getPiece().getColor().equals(this.color) &&
                board.getTile(i).getPiece() instanceof King){
                return (King) board.getTile(i).getPiece();
            }
        }

        //TODO: thrown new custom exception
        throw new RuntimeException();
    }
    
    private Boolean calculateIsInCheck(){
        for(Move opponentMove : opponentLegalMoves){
            if(opponentMove.getDestination().equals(this.king.getPosition())){
                return true;
            }
        }
        return false;
    }
    
    private Boolean calculateIsInCheckMate(){
        return this.isInCheck && this.playerLegalMoves.isEmpty();
    }
    
    private Boolean calculateIsInStaleMate(){
        return !this.isInCheck && this.playerLegalMoves.isEmpty();
    }
}
