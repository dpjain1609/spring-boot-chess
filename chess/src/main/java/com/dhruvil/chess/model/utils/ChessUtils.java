package com.dhruvil.chess.model.utils;

import com.dhruvil.chess.model.board.Board;
import com.dhruvil.chess.model.constant.ChessConstants;
import com.dhruvil.chess.model.game.Game;
import com.dhruvil.chess.model.move.Move;
import com.dhruvil.chess.model.piece.Pawn;
import com.dhruvil.chess.model.player.WhitePlayer;
import com.dhruvil.chess.model.tile.OccupiedTile;
import com.dhruvil.chess.model.tile.Tile;

public class ChessUtils {

    private final static String[] files = new String[]{"a", "b", "c", "d", "e", "f", "g", "h"};
    private final static String[] ranks = new String[]{"1", "2", "3", "4", "5", "6", "7", "8"};

    private ChessUtils(){}

    public static Boolean isValidTile(int tileNumber){
        return tileNumber >= 0 && tileNumber < ChessConstants.TILES_ON_BOARD;
    }

    public static String getAlgebraicNotation(int tileNumber){
        return files[tileNumber % ChessConstants.TILES_ON_FILE] +
                ranks[tileNumber / ChessConstants.TILES_ON_RANK];
    }

    public static String printMove(Move move){
        if(move.getPiece() instanceof Pawn){
            return getAlgebraicNotation(move.getDestination());
        }
        return move.getPiece().toString().concat(getAlgebraicNotation(move.getDestination()));
    }

    public static String fen(Game game){
        Board board = game.getBoard();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(fenBoard(board))
                .append("\t")
                .append(fenTurn((WhitePlayer) game.getWhitePlayer()))
                .append("\t")
                .append(fenCastling())
                .append("\t")
                .append(fenEnPassant())
                .append("\t")
                .append(fenHalfMoveClock())
                .append("\t")
                .append(fenFullMoveNumber());
        return stringBuilder.toString();
    }

    private static String fenBoard(Board board){
        int tileNumber;
        Tile tile;
        StringBuilder stringBuilder = new StringBuilder();
        for(int rank = ChessConstants.TILES_ON_RANK - 1; rank >= 0; rank--){
            for(int file = 0; file < ChessConstants.TILES_ON_FILE; file++){
                tileNumber = (rank * 8) + file;
                tile = board.getTile(tileNumber);

                if(tile instanceof OccupiedTile){
                    stringBuilder.append(tile.getPiece().toString());
                } else{
                    int emptyTiles = 0;
                    do{
                        emptyTiles++;
                        tileNumber++;
                        file++;
                    }while(file < ChessConstants.TILES_ON_FILE && !board.getTile(tileNumber).isOccupied());
                    stringBuilder.append(emptyTiles);
                }
            }
            stringBuilder.append(rank == 0 ? "" : "/");
        }

        return stringBuilder.toString();
    }

    private static String fenTurn(WhitePlayer whitePlayer){
        return whitePlayer.getTurn() ? "w" : "b";
    }

    private static String fenCastling(){
        return "castling";
    }

    private static String fenEnPassant(){
        return "enPassant";
    }

    private static String fenHalfMoveClock() {
        return "halfMoveClock";
    }

    private static String fenFullMoveNumber(){
        return "fullMoveNumber";
    }
}
