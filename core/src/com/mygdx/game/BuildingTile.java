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

    public BuildingTile (BuildingOffsetGrid buildingOffsetGrid){
        setBounds(sprite.getX(),sprite.getY(),sprite.getWidth(),sprite.getHeight());
        setName(buildingOffsetGrid.toString());
        setTouchable(Touchable.disabled);


        setPosition(Utils.caluclateBuildingXPosition(buildingOffsetGrid)-r,
                Utils.calculateBuildingYPosition(buildingOffsetGrid)-r);

        sprite.setPosition(getX(), getY());
        super.positionChanged();
        setVisible(true);
        setName(buildingOffsetGrid.toString());


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
