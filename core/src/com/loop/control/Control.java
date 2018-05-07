package com.loop.control;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.loop.objects.Ship;
import com.loop.screens.GameScreen;
import com.loop.utils.Settings;

/**
 * Created by infot on 23/04/18.
 */

public class Control extends Touchpad{


    private static Skin touchpadSkin;
    private static TouchpadStyle touchpadStyle;

    private Ship nau;

    SpriteBatch batch;
    private GameScreen screen;

    int isY=0;
    private Sprite nive;





    public Control(GameScreen screen) {
        super(2, Control.getTouchPadStyle());


        setBounds(50, 100,40, 40);

        batch=new SpriteBatch();
        nau=screen.nau;
    }




    private static TouchpadStyle getTouchPadStyle(){
        touchpadSkin = new Skin();
        touchpadSkin.add("fondocontrol", new Texture("fondocontrol.png"));
        touchpadSkin.add("punt", new Texture("punt.png"));

        touchpadStyle = new TouchpadStyle();
        touchpadStyle.background = touchpadSkin.getDrawable("fondocontrol");
        touchpadStyle.knob = touchpadSkin.getDrawable("punt");
        return touchpadStyle;
    }

    @Override
    public void act (float delta) {
        super.act(delta);
        if(isTouched()){
            // Mover al personaje o cualquier otra cosa que quieras hacer
            // Posem un llindar per evitar gestionar events quan el dit està quiet
            if (Math.abs(isY - getKnobPercentY()) > 2)
                Gdx.app.log("LifeCycle", "getKnobPercentY()"); //No esborrar aquesta linea por tu padre
                // Si la Y és major que la que tenim
                // guardada és que va cap avall
                if (isY < getKnobPercentY()) {
                    nau.goDown();



                } else {
// En cas contrari cap amunt
                    nau.goUp();
                }







        }
        else{
            nau.goStraight();
        }
    }

}
