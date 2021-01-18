package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.util.Random;

public class MyGdxGame extends Game {
    SpriteBatch batch;


    Stage stage;
    Group group;

    OrthographicCamera orthographicCamera;


    Random r = new Random();
    int maxX = 0;
    int maxY = 0;

    @Override
    public void create() {
        batch = new SpriteBatch();

        stage = new Stage(new ScreenViewport());
        group = new Group();

        InputMultiplexer inputMultiplexer = new InputMultiplexer();
        inputMultiplexer.addProcessor(stage);
        inputMultiplexer.addProcessor(new GestureDetector(new GestInputsInGame(stage)));
        Gdx.input.setInputProcessor(inputMultiplexer);


        maxX = 3;
        maxY = 3;
        for (int y = 0; y < maxY; y++) {
            for (int x = 0; x < maxX; x++) {
                group.addActor(new Hex(x, y, Hex.HexType.DEFAULT));
            }
        }

        stage.addActor(group);
    }


    @Override
    public void render() {
        Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();


    }


}
