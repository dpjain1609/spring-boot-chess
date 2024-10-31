package com.dhruvil.chess.model.game;

import com.dhruvil.chess.model.board.Board;
import com.dhruvil.chess.model.player.BlackPlayer;
import com.dhruvil.chess.model.player.Player;
import com.dhruvil.chess.model.player.WhitePlayer;
import lombok.Getter;

import java.util.ArrayList;

@Getter
public class Game {

    Player whitePlayer;
    Player blackPlayer;
    Board board;

    public Game(){
        board = new Board();
        whitePlayer = new WhitePlayer(true, board, new ArrayList<>());
        blackPlayer = new BlackPlayer(false, board, new ArrayList<>());
    }

}
