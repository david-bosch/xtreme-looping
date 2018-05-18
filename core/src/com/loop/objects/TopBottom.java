package com.loop.objects;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.loop.helpers.AssetManager;
import com.loop.utils.Settings;

/**
 * Created by infot on 18/05/18.
 */

public class TopBottom extends Obstacle {

    private Rectangle hitbox;

    public TopBottom(float x, float y, float width, float height, float velocity) {
        super(x, y, width, height, velocity);


        hitbox=new Rectangle();
        setOrigin();
    }

    public void setOrigin() {

        this.setOrigin(width/2 + 1, height/2);

    }

    @Override
    public void act(float delta) {
        super.act(delta);

        // Actualitzem el Rectangle de col·lisions (punt central de l'asteroid i el radi.
        hitbox.set(position.x, position.y, width-4, height-2);
        setBounds(position.x, position.y, width-8, height-2);

        //     Gdx.app.log("LifeCycle", ""+Settings.VELOCITY_HAZZARD);
    //    setVelocity(Settings.VELOCITY_HAZZARD);

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(AssetManager.barraup, position.x, position.y,width, height);
    }

    public boolean collides(Ship nau) {

        if (position.x <= nau.getX() + nau.getWidth()) {
            return (Intersector.overlaps(hitbox, nau.getCollisionRect()));
        }
        return false;
    }
}
