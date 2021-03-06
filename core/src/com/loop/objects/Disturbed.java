package com.loop.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.loop.helpers.AssetManager;
import com.loop.utils.Methods;
import com.loop.utils.Settings;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by infot on 14/05/18.
 */

public class Disturbed extends Obstacle{
    private Rectangle hitbox;
    Random r;


    private ArrayList<Disturbed> caras;



    public Disturbed(float x, float y, float width, float height, float velocity) {
        super(x, y, width, height, velocity);
        hitbox=new Rectangle();

        r = new Random();
        this.position=new Vector2(x,y);



        setOrigin();
    }



    @Override
    public void act(float delta) {
        super.act(delta);

        // Actualitzem el Rectangle de col·lisions (punt central de l'asteroid i el radi.
      hitbox.set(position.x, position.y, width, height);
        setBounds(position.x, position.y, width, height);

   //     Gdx.app.log("LifeCycle", ""+Settings.VELOCITY_HAZZARD);
        setVelocity(Settings.VELOCITY_HAZZARD);


    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(AssetManager.face, position.x, position.y,width, height);
    }




    public ArrayList<Disturbed> getCaras() {
        return caras;
    }

    public boolean collides(Ship nau) {

        if (position.x <= nau.getX() + nau.getWidth()) {
// Comprovem si han col·lisionat sempre que el hazzard es trobi a la mateixa alçada que l'spacecraft
            return (Intersector.overlaps(hitbox, nau.getCollisionRect()));
        }
        return false;
    }
}



