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
    int num;
    private ArrayList<Disturbed> faces;


    // Objecte random
    Random r;

    public ScrollHandler() {

        //Creem els dos fons
        bg = new Background(0, 0, Settings.GAME_WIDTH * 2, Settings.GAME_HEIGHT, Settings.BG_SPEED);
        bg_back = new Background(bg.getTailX(), 0, Settings.GAME_WIDTH * 2, Settings.GAME_HEIGHT, Settings.BG_SPEED);
        //Afegim els fons (actors) al grup
        addActor(bg);
        addActor(bg_back);

        r = new Random();

        num = 3;
        float newSize = Methods.randomFloat(Settings.MIN_FACE, Settings.MAX_FACE) * 34;
        // Creem l'ArrayList
        faces = new ArrayList<Disturbed>();

        Disturbed cara = new Disturbed(Settings.GAME_WIDTH, r.nextInt(Settings.GAME_HEIGHT - (int) newSize), newSize, newSize, 80);
        faces.add(cara);
        addActor(cara);

        for (int i = 1; i < num; i++) {
            // Creem la mida al·leatòria
            newSize = Methods.randomFloat(Settings.MIN_FACE, Settings.MIN_FACE) * 34;
            // Afegim l'asteroid.
            cara = new Disturbed(faces.get(faces.size() - 1).getTailX() + Settings.GAP, r.nextInt(Settings.GAME_HEIGHT - (int) newSize), newSize, newSize, 80);
            // Afegim l'asteroide a l'ArrayList
            faces.add(cara);
            // Afegim l'asteroide al grup d'actors
            addActor(cara);
        }


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

    }

}