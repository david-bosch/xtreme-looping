package com.loop.objects;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.loop.helpers.AssetManager;

/**
 * Created by infot on 24/04/18.
 */

public class Ship extends Actor {

    private Vector2 position;
    private int width, height;
    private final float defecto=0;

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

    public float getDefecto() {
        return defecto;
    }

    public Vector2 getPosition() {

        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public void rota(float encarado){
        position.rotate(180);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(AssetManager.lanave, position.x, position.y, width, height);

    }
}
