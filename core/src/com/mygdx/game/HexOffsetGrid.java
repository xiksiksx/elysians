package com.mygdx.game;

public class HexOffsetGrid {
    private int x,y;
    public HexOffsetGrid(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "HexOffsetGridData{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
