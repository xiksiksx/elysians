package com.mygdx.game;

public class PositionOfBuildingOffsetGridData {
    private int x,y;
    public PositionOfBuildingOffsetGridData(int x, int y){
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
        return "PositionOfBuildingOffsetGridData{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
