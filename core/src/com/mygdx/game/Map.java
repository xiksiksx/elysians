package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;

import java.util.HashMap;

public class Map {
    private int x, y;
    private Group hexes = new Group();
    private Group buildings = new Group();

    public Map(int x, int y) {
        this.x = x;
        this.y = y;
        hexes.setName("HexMap");
        buildings.setName("Buildings");
    }
    HexOffsetGrid getOfHexPosition(int x, int y) {
        return new HexOffsetGrid(x, y);
    }

    public Group generateBlankMap() {
        HexOffsetGrid hexOffsetGrid;
        for (int yi = 0; yi < y; yi++) {
            for (int xi = 0; xi < x; xi++) {
                hexOffsetGrid = new HexOffsetGrid(xi, yi);
                hexes.addActor(new Hex(hexOffsetGrid, Hex.HexType.INNER));
            }
        }
        return hexes;
    }

    public void addBuilding(HexOffsetGrid hexOffsetGrid, BuildingPosition buildingPosition){
        BuildingOffsetGrid buildingOffsetGrid = getOfBuildingPosition(hexOffsetGrid, buildingPosition);
        Actor actor = buildings.findActor(buildingOffsetGrid.toString());
        if(actor != null){
            Gdx.app.log("Building","Cannot add building because exist");
        }else{
            buildings.addActor(new BuildingTile(buildingOffsetGrid));
        }
        buildings.toFront();
    }

    public Group getAllBuildings(){
        return buildings;
    }


    BuildingOffsetGrid getOfBuildingPosition(HexOffsetGrid positionOfHexOffsetGridData, BuildingPosition buildingPosition) {
        int x = positionOfHexOffsetGridData.getX();
        int y = positionOfHexOffsetGridData.getY();
        switch (buildingPosition) {
            case BOTTOM:
                if(y%2!=0) x++;
                break;
            case LEFT_TOP:
                y++;
                break;
            case RIGHT_TOP:
                y++;
                x++;
                break;
        }
        return new BuildingOffsetGrid(x,y);
    }


}
