package com.mygdx.game;

public class Utils {
    public static final float SIDE=200;
    public static final float DELTA=152;

    public static float calculateHexXPosition(HexOffsetGrid hexOffsetGrid){
        float param = 0;
        if(hexOffsetGrid.getY()%2!=0)
            param = SIDE / 2;
        return hexOffsetGrid.getX()*SIDE+param;
    }

    public static float calculateHexYPosition(HexOffsetGrid hexOffsetGrid){
        return hexOffsetGrid.getY()*DELTA;
    }

    public static float caluclateBuildingXPosition(BuildingOffsetGrid buildingOffsetGrid){
        float param = 0;
        if(buildingOffsetGrid.getY() %2 == 0)
            param=SIDE/2;
        return buildingOffsetGrid.getX()*SIDE+param;
    }

    public static float calculateBuildingYPosition(BuildingOffsetGrid buildingOffsetGrid){
        return buildingOffsetGrid.getY()*DELTA;
    }

}
