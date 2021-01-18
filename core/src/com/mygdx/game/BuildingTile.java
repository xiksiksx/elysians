package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;

public class BuildingTile extends Actor {
    private Sprite sprite = new Sprite(new Texture(Gdx.files.internal("circle.png")));
    private final int r = 25; //radius od circle building

    public BuildingTile (PositionOfBuildingOffsetGridData positionOfBuildingOffsetGridData){
        setBounds(sprite.getX(),sprite.getY(),sprite.getWidth(),sprite.getHeight());
        setName(positionOfBuildingOffsetGridData.toString());
        setTouchable(Touchable.enabled);

        int param = 0;
        if(positionOfBuildingOffsetGridData.getY()%2==0)
            param = PositionOfHexOffsetGridData.SIDE/2;

        setPosition(positionOfBuildingOffsetGridData.getX()*PositionOfHexOffsetGridData.SIDE+param-r,
                positionOfBuildingOffsetGridData.getY()*PositionOfHexOffsetGridData.DELTA-r);
        sprite.setPosition(getX(), getY());
        super.positionChanged();
        setVisible(true);
        setName(positionOfBuildingOffsetGridData.toString());


    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        sprite.draw(batch, parentAlpha);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }
}
