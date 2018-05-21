package com.loop.objects;



/**
 * Created by infot on 14/05/18.
 */

public class Obstacle extends  Scrollable{


    public Obstacle(float x, float y, float width, float height, float velocity) {
        super(x, y, width, height, velocity);
    }
    public void setOrigin() {



            this.setOrigin(width/2 + 1, height/2);

    }

}
