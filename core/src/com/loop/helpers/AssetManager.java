package com.loop.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;



/**
 * Created by infot on 24/04/18.
 */

public class AssetManager {
    public static Texture spaceship;

    //public static Texture fondo;
    public static Texture fondoIMG;
    public static TextureRegion fondo;
    public static Sprite lanave;


    public static void load(){

        spaceship=new Texture(Gdx.files.internal("ship_tr.png"));
      //  spaceship.setFilter(Texture.TextureFilter.Nearest,Texture.TextureFilter.Nearest);
        lanave=new Sprite(spaceship);
        fondoIMG = new Texture(Gdx.files.internal("fondo.png"));
        fondoIMG.setFilter(Texture.TextureFilter.Nearest,Texture.TextureFilter.Nearest);

        fondo=new TextureRegion(fondoIMG);

        fondo.flip(true,true);


        //fondo.setFilter(Texture.TextureFilter.Nearest,Texture.TextureFilter.Nearest);


    }
    public static void dispose(){
        spaceship.dispose();
        fondoIMG.dispose();
        //fondo.dispose();
    }
}
