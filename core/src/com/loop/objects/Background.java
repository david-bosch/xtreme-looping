package com.loop.objects;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.loop.helpers.AssetManager;

/**
 * Created by infot on 24/04/18.
 */

public class Background extends Scrollable {
    public Background(float x, float y, float width, float height, float velocity) {
        super(x, y, width, height, velocity);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        batch.disableBlending();
        batch.draw(AssetManager.fondo, position.x, position.y, width, height);
        batch.enableBlending();
    }
}