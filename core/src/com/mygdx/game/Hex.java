package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;

import java.util.Random;

public class Hex extends Actor {
    public static final String DEFAUL_IMG = "hex.png";
    public static final int HEIGHT = 200;
    public static final int WIDTH = 200;
    public static final int DELTA = 152;
    private final int row = 0;
    private final int column = 0;

    private Sprite sprite;

    public Hex(int x, int y, HexType hexType) {
        int param = 0;
        if (y % 2 != 0)
            param = Hex.HEIGHT / 2;
        sprite = new Sprite(new Texture(hexType.getPathToImg()));
        setBounds(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());
        setTouchable(Touchable.enabled);
        setPosition((float) Hex.WIDTH * x + param, (float) Hex.DELTA * y);
        sprite.setPosition(getX(), getY());
        super.positionChanged();
        String name = "x: " + x + " y: " + y;

        System.out.println(name);
        System.out.println(getX() + " " + getY());
        setVisible(true);
        setName(name);


        Random r = new Random();

        //setColor(r.nextFloat(),r.nextFloat(),r.nextFloat(),1);

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










