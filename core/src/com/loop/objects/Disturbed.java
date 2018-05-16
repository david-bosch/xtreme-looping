package com.loop.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.loop.helpers.AssetManager;
import com.loop.utils.Methods;
import com.loop.utils.Settings;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by infot on 14/05/18.
 */

public class Disturbed extends Obstacle{
    private Circle hitbox;
    Random r;
    int pertur;

    private ArrayList<Disturbed> caras;



    public Disturbed(float x, float y, float width, float height, float velocity) {
        super(x, y, width, height, velocity);
        hitbox=new Circle();

        r = new Random();
        this.position=new Vector2(x,y);

        pertur = r.nextInt(15);

        setOrigin();
    }

    public void setOrigin() {

        this.setOrigin(width/2 + 1, height/2);

    }

    @Override
    public void act(float delta) {
        super.act(delta);

        // Actualitzem el cercle de col·lisions (punt central de l'asteroid i el radi.
        hitbox.set(position.x + width / 2.0f, position.y + width / 2.0f, width / 2.0f);

        Gdx.app.log("LifeCycle", ""+Settings.VELOCITY_HAZZARD);
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

        // Comprovem les col·lisions entre cada asteroid i la nau
        for (Disturbed laface : caras) {
            if (laface.collides(nau)) {
                return true;
            }
        }
        return false;
    }
}



