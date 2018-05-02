package com.loop.objects;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.loop.control.Control;
import com.loop.helpers.AssetManager;
import com.loop.utils.Settings;

/**
 * Created by infot on 24/04/18.
 */

public class Ship extends Actor{

    private Vector2 position;
    private int width, height;
    public float grade;
    Sprite nave=AssetManager.lanave;

    public static final int SPACECRAFT_STRAIGHT = 0;
    public static final int SPACECRAFT_UP = 1;
    public static final int SPACECRAFT_DOWN = 2;
    private int direction;


    public Ship(float x, float y, int width, int height){
        this.width=width;
        this.height=height;
        this.position=new Vector2(x,y);


    }

    @Override
    public float getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public float getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }



    public Vector2 getPosition() {

        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }



    public void act(float delta){
        switch (direction) {
            case SPACECRAFT_UP:
                if (this.position.y - Settings.SPACECRAFT_VELOCITY * delta >= 0) {
                    this.position.y -= Settings.SPACECRAFT_VELOCITY * delta;
                }
                break;
            case SPACECRAFT_DOWN:
                if (this.position.y + height + Settings.SPACECRAFT_VELOCITY * delta <= Settings.GAME_HEIGHT) {
                    this.position.y += Settings.SPACECRAFT_VELOCITY * delta;
                }
                break;
            case SPACECRAFT_STRAIGHT:
                break;
        }
    }

    public Sprite getNave() {
        return nave;
    }

    public void setNave(Sprite nave) {
        this.nave = nave;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);


        batch.draw(nave, position.x, position.y, width, height);


    }
}
