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
    public static Texture sheet;
    public static Sprite barraH;
    public static Sprite barraup;
    public static Texture barraup1;
    public static Sprite esfera;
    public static Texture esfera1;

    public static Sprite barrap;
    public static Texture barrap1;

    public static Sprite meta;
    public static Texture meta1;



    public static Texture barra;

    public static TextureRegion[] explosion;
    public static Animation explosionAnim;

    public static void load() {

        sheet=new Texture(Gdx.files.internal("sheet.png"));

        spaceship = new Texture(Gdx.files.internal("ship_tr.png"));
        //  spaceship.setFilter(Texture.TextureFilter.Nearest,Texture.TextureFilter.Nearest);
        lanave = new Sprite(spaceship);

        face1 = new Texture(Gdx.files.internal("disturbed_hazzard.png"));

        barra = new Texture(Gdx.files.internal("pared_h.png"));

        barraH = new Sprite(barra);

        barrap1 = new Texture(Gdx.files.internal("pared.png"));

        barrap = new Sprite(barrap1);
        barrap.flip(false, true);

        barraup1 = new Texture(Gdx.files.internal("TopBottom.png"));
        barraup = new Sprite(barraup1);

        meta1 = new Texture(Gdx.files.internal("meta.png"));
        meta = new Sprite(meta1);

        meta.flip(false, true);


        face = new Sprite(face1);
        face.flip(false, true);
        fondoIMG = new Texture(Gdx.files.internal("fondo.png"));
        fondoIMG.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);

        fondo = new TextureRegion(fondoIMG);

        fondo.flip(false, false);

        esfera1 = new Texture(Gdx.files.internal("esferic.png"));
        //  spaceship.setFilter(Texture.TextureFilter.Nearest,Texture.TextureFilter.Nearest);
        esfera = new Sprite(esfera1);
        esfera.flip(false,true);


        //fondo.setFilter(Texture.TextureFilter.Nearest,Texture.TextureFilter.Nearest);

        music = Gdx.audio.newMusic(Gdx.files.internal("tema.wav"));
        music.setVolume(0.2f);
        music.setLooping(true);

        //  boom = Gdx.audio.newSound(Gdx.files.internal("boom.wav"));

        //  record = Gdx.audio.newSound(Gdx.files.internal("record.wav"));


        // Creem els 16 estats de l'explosió
        explosion = new TextureRegion[16];

// Carreguem els 16 estats de l'explosió
        int index = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 8; j++) {
                explosion[index++] = new TextureRegion(sheet, j * 64, i * 64 + 49, 64, 64);
                explosion[index - 1].flip(false, true);
            }


        }
        explosionAnim = new Animation(0.04f, explosion);
    }
    public static void dispose(){
        spaceship.dispose();
        fondoIMG.dispose();
      //  boom.dispose();
        music.dispose();
    //    record.dispose();
    }
}
