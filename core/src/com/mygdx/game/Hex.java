package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;

public class Hex extends Actor {
    private final int DELTA = 152;

    private Sprite sprite;

    public Hex(PositionOfHexOffsetGridData positionOfHexOffsetGridData, HexType hexType) {
        sprite = new Sprite(new Texture(hexType.getPathToImg()));
        setBounds(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());

        float param = 0;
        if (positionOfHexOffsetGridData.getY() % 2 != 0)
            param = sprite.getHeight() / 2;
        setTouchable(Touchable.enabled);
        setPosition(PositionOfHexOffsetGridData.SIDE * positionOfHexOffsetGridData.getX() + param,
                PositionOfHexOffsetGridData.DELTA * positionOfHexOffsetGridData.getY());
        sprite.setPosition(getX(), getY());
        super.positionChanged();
        setVisible(true);
        setName(positionOfHexOffsetGridData.toString());

    }



    @Override
    public void draw(Batch batch, float parentAlpha) {
        sprite.draw(batch, parentAlpha);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }


    enum HexType {
        DEFAULT("hex.png"),
        INNER("");

        private String pathToImg;

        HexType(String pathToImg) {
            this.pathToImg = pathToImg;
        }

        public String getPathToImg() {
            return pathToImg;
        }

    }
}










