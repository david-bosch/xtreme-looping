package com.loop.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
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
    public float grade=0f;
    private static final float verticalUp=-90f;
    private static final float verticalDown=90f;
    private static final float horizontalRight=0f;
    private static final float horizontalLeft=180f;
    private boolean verticalUpBloq=false;



    public static final int SPACECRAFT_STRAIGHT = 0;
    public static final int SPACECRAFT_UP = 1;
    public static final int SPACECRAFT_DOWN = 2;
    public static final int SPACECRAFT_LEFT = 3;
    public static final int SPACECRAFT_RIGHT = 4;
    private int direction;
    private float acelera=0;
    private float desceleraUP=-75.60014f;
    private float desceleraUPFinal=-144.40009f;
    private float desceleraDown=75.60014f;
    private float desceleraDownFinal=144.40009f;

    private Rectangle collisionRect;


    public Ship(float x, float y, int width, int height){
        this.width=width;
        this.height=height;
        this.position=new Vector2(x,y);
        collisionRect = new Rectangle();


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
  //      Gdx.app.log("rotacio+++++++++++++", ""+AssetManager.lanave.getRotation());
      /*  Gdx.app.log("tirali--------------", ""+acelera);
        Gdx.app.log("destirali///////////", ""+desceleraUP);*/
      //  Gdx.app.log("destirali///////////", ""+desceleraDown);

        if(AssetManager.lanave.getRotation()==verticalUp) {
            verticalUpBloq=true;
        }else{
            verticalUpBloq=false;
        }
        collisionRect.set(position.x, position.y + 3, width, 10);
        setBounds(position.x, position.y, width, height);


        AssetManager.lanave.rotate(grade);

        if((AssetManager.lanave.getRotation()==359)||(AssetManager.lanave.getRotation()==-359)){//Aquest if s'encarrega que els graus siguin sempre els matiexos
            AssetManager.lanave.setRotation(0);
            acelera=0;
            desceleraUP=-75.60014f;
            desceleraUPFinal=-144.40009f;

           desceleraDown=75.60014f;
            desceleraDownFinal=144.40009f;
        }


        ///Regulació de ascendencia i decendencia al girar

        //regulacio ascendent
        if((AssetManager.lanave.getRotation()<0)&&(AssetManager.lanave.getRotation()>=-90)){ //Regula la velocitat ascendent primer quart
            if (this.position.y - Settings.SPACECRAFT_VELOCITY-acelera * delta >= 0) {
                this.position.y -= Settings.SPACECRAFT_VELOCITY-acelera * delta;

                }


      } else if((AssetManager.lanave.getRotation()<-90)&&(AssetManager.lanave.getRotation()>=-180)){
            if (this.position.y - Settings.SPACECRAFT_VELOCITY-desceleraUP * delta >= 0) {
                this.position.y -= Settings.SPACECRAFT_VELOCITY-desceleraUP * delta;}


        } else if((AssetManager.lanave.getRotation()<-180)&&(AssetManager.lanave.getRotation()>=-270)){
        if (this.position.y - Settings.SPACECRAFT_VELOCITY-desceleraUP * delta >= 0) {
            this.position.y -= Settings.SPACECRAFT_VELOCITY-desceleraUP * delta;}



    } else if((AssetManager.lanave.getRotation()<-270)&&(AssetManager.lanave.getRotation()>=-358)){
            if (this.position.y - Settings.SPACECRAFT_VELOCITY+desceleraUPFinal * delta >= 0) {
                this.position.y -= Settings.SPACECRAFT_VELOCITY+desceleraUPFinal * delta;}

    }


        else if((AssetManager.lanave.getRotation()>0)&&(AssetManager.lanave.getRotation()<=90)){//Regula la velocitat descendent
            if (this.position.y + height + Settings.SPACECRAFT_VELOCITY+acelera * delta <= Settings.GAME_HEIGHT) {
                this.position.y += Settings.SPACECRAFT_VELOCITY+acelera * delta;}
        }



     else if((AssetManager.lanave.getRotation()>90)&&(AssetManager.lanave.getRotation()<=180)){
            if (this.position.y - Settings.SPACECRAFT_VELOCITY-desceleraDown * delta>=0) {
                this.position.y -= Settings.SPACECRAFT_VELOCITY-desceleraDown * delta;

            }


    } else if((AssetManager.lanave.getRotation()>180)&&(AssetManager.lanave.getRotation()<=270)){
            if (this.position.y + height + Settings.SPACECRAFT_VELOCITY+desceleraDown * delta>=0) {
                this.position.y += Settings.SPACECRAFT_VELOCITY+desceleraDown * delta;}



    } else if((AssetManager.lanave.getRotation()>270)&&(AssetManager.lanave.getRotation()<=358)){
            if (this.position.y + height + Settings.SPACECRAFT_VELOCITY-desceleraDownFinal * delta <= Settings.GAME_HEIGHT) {
                this.position.y += Settings.SPACECRAFT_VELOCITY-desceleraDownFinal * delta;}

    }



        ///Regulació de ascendencia i decendencia al girar
//---------------------------------------------------------------------------------//

        switch (direction) {
            case SPACECRAFT_UP:
               if(!verticalUpBloq) {
                  /*  if (this.position.y - Settings.SPACECRAFT_VELOCITY * delta >= 0) {
                        this.position.y -= Settings.SPACECRAFT_VELOCITY * delta;*/
                        grade=-1;
                        acelera=acelera-0.4f;
                        desceleraUP=desceleraUP+0.4f;
                        desceleraUPFinal=desceleraUPFinal+0.4f;
                        desceleraDown=desceleraDown+0.4f;
                        desceleraDownFinal=desceleraDownFinal+0.4f;
                   }
         //       }else{
              //      break;
         //       }
                break;
            case SPACECRAFT_DOWN:
         /*       if (this.position.y + height + Settings.SPACECRAFT_VELOCITY * delta <= Settings.GAME_HEIGHT) {
                    this.position.y += Settings.SPACECRAFT_VELOCITY * delta;

                }*/
                grade=+1;
                acelera=acelera+0.4f;
                desceleraUP=desceleraUP-0.4f;

                desceleraUPFinal=desceleraUPFinal-0.4f;
                desceleraDown=desceleraDown-0.4f;
                desceleraDownFinal=desceleraDownFinal-0.4f;

                break;
            case SPACECRAFT_STRAIGHT:
                break;
        }


    }



    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);


      //  batch.draw(AssetManager.lanave, position.x, position.y, width, height);
        AssetManager.lanave.setSize(width,height);
        AssetManager.lanave.setX(position.x);
        AssetManager.lanave.setY(position.y);

        AssetManager.lanave.draw(batch);


    }
    // Canviem la direcció de l'Spacecraft: Puija
    public void goUp() {
        direction = SPACECRAFT_UP;



    }

    // Canviem la direcció de l'Spacecraft: Baixa
    public void goDown() {

        direction = SPACECRAFT_DOWN;


    }

    // Posem l'Spacecraft al seu estat original
    public void goStraight() {
        direction = SPACECRAFT_STRAIGHT;
        grade=0;
    }

    public Rectangle getCollisionRect() {
        return collisionRect;
    }
}
