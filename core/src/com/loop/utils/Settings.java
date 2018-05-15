package com.loop.utils;

/**
 * Created by infot on 24/04/18.
 */

public class Settings {

    // Mida del joc, s'escalarà segons la necessitat
    public static final int GAME_WIDTH = 240;
    public static final int GAME_HEIGHT = 135;

    // Propietats de la nau
    public static final float SPACECRAFT_VELOCITY = 0;
    public static final int SPACECRAFT_WIDTH = 16;
    public static final int SPACECRAFT_HEIGHT = 7;
    public static final float SPACECRAFT_STARTX = 70;
    public static final float SPACECRAFT_STARTY = GAME_HEIGHT/2 - SPACECRAFT_HEIGHT/2;

    //SCROLLABLE
    public static final int BG_SPEED = -50;
    public static final int GAP = 75;

    //propietats dels obstacles

    public static final float MAX_FACE = 1.5f;
    public static final float MIN_FACE = 0.5f;

    public static int VELOCITY_HAZZARD;
}
