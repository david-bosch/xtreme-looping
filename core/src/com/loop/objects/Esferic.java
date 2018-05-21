package com.loop.objects;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;
import com.loop.helpers.AssetManager;
import com.loop.utils.Settings;


import java.util.Random;

/**
 * Created by infot on 21/05/18.
 */

public class Esferic extends Obstacle {
    Circle hitbox;
    Random r; int u;
    public Esferic(float x, float y, float width, float height, float velocity) {
        super(x, y, width, height, velocity);
        hitbox=new Circle();


        this.position=new Vector2(x,y);



        setOrigin();
    }
    @Override
    public void act(float delta) {
        super.act(delta);
        r = new Random();
        u = r.nextInt(1 + 1 + 1) - 1;
        // Actualitzem el cecrcle de col·lisions (punt central de l'asteroid i el radi.
        hitbox.set(position.x + width / 2.0f, position.y + width / 2.0f, width / 2.0f);

        //     Gdx.app.log("LifeCycle", ""+Settings.VELOCITY_HAZZARD);
        setVelocity(Settings.VELOCITY_HAZZARD);
        position.y=position.y+u;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(AssetManager.esfera, position.x, position.y,width, height);
    }


    public boolean collides(Ship nau) {

        if (position.x <= nau.getX() + nau.getWidth()) {
// Comprovem si han col·lisionat sempre que el hazzard es trobi a la mateixa alçada que l'spacecraft
            return (Intersector.overlaps(hitbox, nau.getCollisionRect()));
        }
        return false;
    }
}
