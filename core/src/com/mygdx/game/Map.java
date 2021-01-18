package com.mygdx.game;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private int x, y;

    public Map(int x, int y) {
        this.x = x;
        this.y = y;

    }

    PositionOfHexOffsetGridData getOfHexPosition(int x, int y) {
        return new PositionOfHexOffsetGridData(x, y);
    }


    PositionOfBuildingOffsetGridData getOfBuildingPosition(PositionOfHexOffsetGridData positionOfHexOffsetGridData, BuildingPosition buildingPosition) {
        int x = positionOfHexOffsetGridData.getX();
        int y = positionOfHexOffsetGridData.getY();
        switch (buildingPosition) {
            case BOTTOM:
                break;
            case LEFT_TOP:
                y++;
                break;
            case RIGHT_TOP:
                y++;
                x++;
                break;
        }
        return new PositionOfBuildingOffsetGridData(x,y);
    }


}
