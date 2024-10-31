package com.dhruvil.chess.model.constant;

public class ChessConstants {
    public static final Integer TILES_ON_BOARD = 64;
    public static final Integer TILES_ON_FILE = 8;
    public static final Integer TILES_ON_RANK = 8;

    public static final boolean[] isOnFirstFile = isOnFile(0);
    public static final boolean[] isOnSecondFile = isOnFile(1);
    public static final boolean[] isOnSeventhFile = isOnFile(6);
    public static final boolean[] isOnEighthFile = isOnFile(7);

    private static boolean[] isOnFile(Integer n){
        boolean[] board = new boolean[TILES_ON_BOARD];
        for(int i = n; i < TILES_ON_BOARD; i+=8){
            board[i] = true;
        }
        return board;
    }

    private static boolean[] isOnRank(Integer n){
        boolean[] board = new boolean[TILES_ON_BOARD];
        for(int i = 0; i < TILES_ON_RANK; i++)
            board[(n * 8) + i] = true;
        return board;
    }
}
