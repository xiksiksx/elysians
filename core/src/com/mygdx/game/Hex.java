package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;

public class Hex extends Actor {

    private Sprite sprite;
    private HexOffsetGrid positionOfHexOffsetGridData;

    public Hex(HexOffsetGrid positionOfHexOffsetGridData, HexType hexType) {
        this.positionOfHexOffsetGridData = positionOfHexOffsetGridData;
        sprite = new Sprite(new Texture(hexType.getPathToImg()));
        setBounds(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());

        setTouchable(Touchable.enabled);
        setPosition(Utils.calculateHexXPosition(positionOfHexOffsetGridData),
                Utils.calculateHexYPosition(positionOfHexOffsetGridData));
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
        if (hasKeyboardFocus()) {
            sprite.setColor(0.85f,0.85f,0.85f,1);
        } else {
            sprite.setColor(Color.WHITE);
        }
    }

    public HexOffsetGrid getPositionOfHexOffsetGridData() {
        return positionOfHexOffsetGridData;
    }

    enum HexType {
        DEFAULT("hex.png"),
        INNER("hexagontest.png");

        private String pathToImg;

        HexType(String pathToImg) {
            this.pathToImg = pathToImg;
        }

        public String getPathToImg() {
            return pathToImg;
        }

    }
}










