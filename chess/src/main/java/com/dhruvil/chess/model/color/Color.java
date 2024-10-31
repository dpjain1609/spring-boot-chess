package com.dhruvil.chess.model.color;

public enum Color {
    WHITE(1),
    BLACK(-1);

    public final Integer direction;

    Color(Integer direction){
        this.direction = direction;
    }

}
