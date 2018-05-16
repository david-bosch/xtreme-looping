package com.loop.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.loop.objects.Disturbed;


/**
 * Created by infot on 24/04/18.
 */

public class AssetManager {
    public static Texture spaceship;

    //public static Texture fondo;
    public static Texture fondoIMG;
    public static TextureRegion fondo;
    public static Sprite lanave;
    public static Music music;
    public static Sound boom;
    public static Sound record;
    public static Sprite face;
    public static Texture face1;

    public static TextureRegion[] explosion;
    public static Animation explosionAnim;

    public static void load(){

        spaceship=new Texture(Gdx.files.internal("ship_tr.png"));
      //  spaceship.setFilter(Texture.TextureFilter.Nearest,Texture.TextureFilter.Nearest);
        lanave=new Sprite(spaceship);

        face1=new Texture(Gdx.files.internal("disturbed_hazzard.png"));

        face=new Sprite(face1);
        face.flip(false,true);
        fondoIMG = new Texture(Gdx.files.internal("fondo.png"));
        fondoIMG.setFilter(Texture.TextureFilter.Nearest,Texture.TextureFilter.Nearest);

        fondo=new TextureRegion(fondoIMG);

        fondo.flip(false,false);


        //fondo.setFilter(Texture.TextureFilter.Nearest,Texture.TextureFilter.Nearest);

        music = Gdx.audio.newMusic(Gdx.files.internal("tema.wav"));
        music.setVolume(0.2f);
        music.setLooping(true);

     //   boom = Gdx.audio.newSound(Gdx.files.internal("boom.wav"));

      //  record = Gdx.audio.newSound(Gdx.files.internal("record.wav"));




    }
    public static void dispose(){
        spaceship.dispose();
        fondoIMG.dispose();
     //   boom.dispose();
        music.dispose();
    //    record.dispose();
    }
}
