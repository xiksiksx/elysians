package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class GestInputsInGame implements GestureDetector.GestureListener {
    Stage stage;

    public GestInputsInGame(Stage stage) {
        this.stage = stage;
    }

    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean tap(float x, float y, int count, int button) {
        Vector2 vector2 = stage.screenToStageCoordinates(new Vector2((float) x, (float) y));
        Actor actor = stage.hit(vector2.x, vector2.y, false);
        if (actor != null) {
            System.out.println("name: " + actor.getName());
            System.out.println("hex position <x: " + actor.getX() + " y: " + actor.getY() + ">");
            ((OrthographicCamera) stage.getCamera()).position.x = actor.getX() + Hex.WIDTH / 2;
            ((OrthographicCamera) stage.getCamera()).position.y = actor.getY() + Hex.WIDTH / 2;

        }

        System.out.println("tap position <x: " + x + " y: " + y + ">");

        return true;
    }

    @Override
    public boolean longPress(float x, float y) {
        return false;
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {
        return false;
    }

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {

        ((OrthographicCamera) stage.getCamera()).translate(-deltaX, deltaY);
        stage.getCamera().update();

        return true;
    }

    @Override
    public boolean panStop(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean zoom(float initialDistance, float distance) {
        float zoom = ((OrthographicCamera) stage.getCamera()).zoom;
        System.out.println("Zoom: " + zoom);

        if (initialDistance >= distance && zoom < 2) {
            ((OrthographicCamera) stage.getCamera()).zoom += 0.02;
        }
        if (initialDistance <= distance && zoom > 0.25) {
            ((OrthographicCamera) stage.getCamera()).zoom -= 0.02;

        }
        return false;
    }

    @Override
    public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
        return false;
    }

    @Override
    public void pinchStop() {

    }
}
