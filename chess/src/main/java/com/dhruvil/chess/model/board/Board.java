package com.dhruvil.chess.model.board;

import com.dhruvil.chess.model.color.Color;
import com.dhruvil.chess.model.piece.*;
import com.dhruvil.chess.model.tile.EmptyTile;
import com.dhruvil.chess.model.tile.OccupiedTile;
import com.dhruvil.chess.model.tile.Tile;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final List<Tile> board;

    public Board(){
        board = buildStandardBoard();
    }

    public Board(List<Tile> board){
        this.board = board;
    }

    public Tile getTile(Integer tileNumber){
        return board.get(tileNumber);
    }

    private List<Tile> buildStandardBoard(){
        List<Tile> board = new ArrayList<>();

        // white pieces
        board.add(new OccupiedTile(0, new Rook(0, Color.WHITE, true)));
        board.add(new OccupiedTile(1, new Knight(1, Color.WHITE, true)));
        board.add(new OccupiedTile(2, new Bishop(2, Color.WHITE, true)));
        board.add(new OccupiedTile(3, new King(3, Color.WHITE, true)));
        board.add(new OccupiedTile(4, new Queen(4, Color.WHITE, true)));
        board.add(new OccupiedTile(5, new Bishop(5, Color.WHITE, true)));
        board.add(new OccupiedTile(6, new Knight(6, Color.WHITE, true)));
        board.add(new OccupiedTile(7, new Rook(7, Color.WHITE, true)));
        board.add(new OccupiedTile(8, new Pawn(8, Color.WHITE, true)));
        board.add(new OccupiedTile(9, new Pawn(9, Color.WHITE, true)));
        board.add(new OccupiedTile(10, new Pawn(10, Color.WHITE, true)));
        board.add(new OccupiedTile(11, new Pawn(11, Color.WHITE, true)));
        board.add(new OccupiedTile(12, new Pawn(12, Color.WHITE, true)));
        board.add(new OccupiedTile(13, new Pawn(13, Color.WHITE, true)));
        board.add(new OccupiedTile(14, new Pawn(14, Color.WHITE, true)));
        board.add(new OccupiedTile(15, new Pawn(15, Color.WHITE, true)));

        // empty tiles
        for(int i = 16; i <= 47; i++){
            board.add(new EmptyTile(i));
        }

        // black pieces
        board.add(new OccupiedTile(48, new Pawn(48, Color.BLACK, true)));
        board.add(new OccupiedTile(49, new Pawn(49, Color.BLACK, true)));
        board.add(new OccupiedTile(50, new Pawn(50, Color.BLACK, true)));
        board.add(new OccupiedTile(51, new Pawn(51, Color.BLACK, true)));
        board.add(new OccupiedTile(52, new Pawn(52, Color.BLACK, true)));
        board.add(new OccupiedTile(53, new Pawn(53, Color.BLACK, true)));
        board.add(new OccupiedTile(54, new Pawn(54, Color.BLACK, true)));
        board.add(new OccupiedTile(55, new Pawn(55, Color.BLACK, true)));
        board.add(new OccupiedTile(56, new Rook(56, Color.BLACK, true)));
        board.add(new OccupiedTile(57, new Knight(57, Color.BLACK, true)));
        board.add(new OccupiedTile(58, new Bishop(58, Color.BLACK, true)));
        board.add(new OccupiedTile(59, new King(59, Color.BLACK, true)));
        board.add(new OccupiedTile(60, new Queen(60, Color.BLACK, true)));
        board.add(new OccupiedTile(61, new Bishop(61, Color.BLACK, true)));
        board.add(new OccupiedTile(62, new Knight(62, Color.BLACK, true)));
        board.add(new OccupiedTile(63, new Rook(63, Color.BLACK, true)));

        return board;
    }

    public void printBoard(){
        for(int i = 63; i >= 0; i--){
            System.out.print(board.get(i) + " ");
            if(i % 8 == 0) {
                System.out.println();
            }
        }
    }

}
