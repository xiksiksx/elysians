package com.mygdx.game;

public class PositionOfHexOffsetGridData {
    private int x,y;
    public static final int DELTA = 152; //pixels from bottom to left and right corner
    public static final int SIDE = 200; //pixels of HEX sprite
    public PositionOfHexOffsetGridData(int x, int y){
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
