package com.loop.objects;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.loop.utils.Methods;
import com.loop.utils.Settings;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by infot on 24/04/18.
 */

public class ScrollHandler extends Group {

    // Fons de pantalla
    Background bg, bg_back;
    int num, num2;
    private ArrayList<Disturbed> faces;
    private ArrayList<BarraH> barrash;
    BarraP barrap;

    TopBottom top,top2,abajo,abajo2;
    Meta fin;



    // Objecte random
    Random r;

    public ScrollHandler() {

        //Creem els dos fons
       bg = new Background(0, 0, Settings.GAME_WIDTH * 2, Settings.GAME_HEIGHT, Settings.BG_SPEED);
        bg_back = new Background(bg.getTailX(), 0, Settings.GAME_WIDTH * 2, Settings.GAME_HEIGHT, Settings.BG_SPEED);
        //Afegim els fons (actors) al grup
        addActor(bg);
        addActor(bg_back);

        top=new TopBottom(0,0,Settings.GAME_WIDTH,3,Settings.BG_SPEED);
        top2=new TopBottom(top.getTailX(),0,Settings.GAME_WIDTH,3,Settings.BG_SPEED);

        addActor(top);
        addActor(top2);

        abajo=new TopBottom(0,Settings.GAME_HEIGHT-3,Settings.GAME_WIDTH,3,Settings.BG_SPEED);
        abajo2=new TopBottom(top.getTailX(),Settings.GAME_HEIGHT-3,Settings.GAME_WIDTH,3,Settings.BG_SPEED);

        addActor(abajo);
        addActor(abajo2);

        barrap=new BarraP(0,0,50,Settings.GAME_HEIGHT,Settings.VELOCITY_HAZZARD);

        addActor(barrap);
        r = new Random();

        num = 70;
        num2=10;
        float newSize = Methods.randomFloat(Settings.MIN_FACE, Settings.MAX_FACE) * 34;

        // Creem l'ArrayList
        faces = new ArrayList<Disturbed>();
        barrash=new ArrayList<BarraH>();

        Disturbed cara = new Disturbed(Settings.GAME_WIDTH, r.nextInt(Settings.GAME_HEIGHT - (int) newSize), newSize, newSize, Settings.VELOCITY_HAZZARD);
        faces.add(cara);
        addActor(cara);

        for (int i = 1; i < num; i++) {
            // Creem la mida al·leatòria
            newSize = Methods.randomFloat(Settings.MIN_FACE, Settings.MIN_FACE) * 34;





            // Afegim l'asteroid.
            cara = new Disturbed(faces.get(faces.size() - 1).getTailX() + Settings.GAP_CUBE, r.nextInt(Settings.GAME_HEIGHT - (int) newSize), newSize, newSize, Settings.VELOCITY_HAZZARD);
            // Afegim l'asteroide a l'ArrayList
            faces.add(cara);
            // Afegim l'asteroide al grup d'actors
            addActor(faces.get(i));
        }

        BarraH barra=new BarraH(faces.get(faces.size() - 1).getTailX() + Settings.GAP, 80, Settings.barraXh, Settings.Barrayh, Settings.VELOCITY_HAZZARD);
        barrash.add(barra);
        addActor(barra);


        for (int i = 1; i < num2; i++) {
            // Creem la mida al·leatòria barrash.add(barra);
            newSize = Methods.randomFloat(Settings.MIN_FACE, Settings.MIN_FACE) * 34;
            if(num2%2==0){
                barra = new BarraH(barrash.get(barrash.size() - 1).getTailX() + Settings.GAP, r.nextInt(Settings.GAME_HEIGHT - (int) newSize), Settings.barraXv, Settings.Barrayv, Settings.VELOCITY_HAZZARD);
                barrash.add(barra);
                addActor(barrash.get(i));
            }
            else if(num2%2!=0){
                barra = new BarraH(barrash.get(barrash.size() - 1).getTailX() + Settings.GAP, r.nextInt(Settings.GAME_HEIGHT - (int) newSize), Settings.barraXh, Settings.Barrayh, Settings.VELOCITY_HAZZARD);
                barrash.add(barra);
                addActor(barrash.get(i));
            }

        }

        fin=new Meta(barrash.get(barrash.size() - 1).getTailX() + Settings.GAP,0,50,Settings.GAME_HEIGHT,Settings.VELOCITY_HAZZARD);
        addActor(fin);

    }

    @Override
    public void act(float delta) {
        super.act(delta);
        // Si algun element està fora de la pantalla, fem un reset de l'element.
        if (bg.isLeftOfScreen()) {
            bg.reset(bg_back.getTailX());

        } else if (bg_back.isLeftOfScreen()) {
            bg_back.reset(bg.getTailX());

        }
        if (top.isLeftOfScreen()) {
            top.reset(top2.getTailX());

        } else if (top2.isLeftOfScreen()) {
            top2.reset(top.getTailX());

        }
        if (abajo.isLeftOfScreen()) {
            abajo.reset(abajo2.getTailX());

        } else if (abajo2.isLeftOfScreen()) {
            abajo2.reset(abajo.getTailX());

        }



    }

    public boolean collides(Ship nave) {

// Comprovem les col·lisions entre cada hazzard i la nau
        for (Disturbed dis : faces) {
            if (dis.collides(nave)) {
                return true;
            }
        }
        for (BarraH bar : barrash) {
            if (bar.collides(nave)) {
                return true;
            }
        }

            if (barrap.collides(nave)) {
                return true;
            }
        if (top.collides(nave)) {
            return true;
        }else if(top2.collides(nave)){
            return true;
        }

        if (abajo.collides(nave)) {
            return true;
        }else if(abajo2.collides(nave)){
            return true;
        }


        return false;
    }
    public boolean end(Ship nave){

        if (fin.collides(nave)) {
            return true;
        }

        return false;
    }

}