package com.loop.utils;

/**
 * Created by infot on 15/05/18.
 */
import java.util.Random;

public class Methods {

    // Mètode que torna un float aleatòri entre un mínim i un màxim
    public static float randomFloat(float min, float max) {
        Random r = new Random();
        return r.nextFloat() * (max - min) + min;

    }
}