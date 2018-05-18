package com.loop.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.loop.control.Control;
import com.loop.helpers.AssetManager;
import com.loop.objects.ScrollHandler;
import com.loop.objects.Ship;
import com.loop.utils.Settings;

/**
 * Created by infot on 24/04/18.
 */

public class GameScreen implements Screen {

    Boolean gameOver = false;
    Boolean endGame = false;
    private ShapeRenderer shapeRenderer;
    private Batch batch;
    Control control;
    public Stage stage;
    public Ship nau;
    ScrollHandler scroller;
    private float explosionTime = 0;


    public GameScreen(){
        AssetManager.music.play();
        shapeRenderer = new ShapeRenderer();


        OrthographicCamera camera = new OrthographicCamera(Settings.GAME_WIDTH, Settings.GAME_HEIGHT);

        camera.setToOrtho(true);
        StretchViewport viewport = new StretchViewport(Settings.GAME_WIDTH, Settings.GAME_HEIGHT , camera);
        stage = new Stage(viewport);
        batch = stage.getBatch();
        nau=new Ship(Settings.SPACECRAFT_STARTX, Settings.SPACECRAFT_STARTY, Settings.SPACECRAFT_WIDTH, Settings.SPACECRAFT_HEIGHT);
        control=new Control(this);

         scroller=new ScrollHandler();

        stage.addActor(scroller);
        stage.addActor(control);
        control.setPosition(190, 90);
        Gdx.input.setInputProcessor(stage);



        stage.addActor(nau);

        nau.setName("theship");

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {


            stage.draw();
            stage.act(delta);


            if(scroller.end(nau)){
                Gdx.app.log("App", "Succes as fuck");
                endGame=true;
            }
            if (scroller.collides(nau)) {
                //  AssetManager.boom.play();



//                stage.getRoot().findActor("theship").remove();

                gameOver = true;
            }
        if(gameOver){
            // Si hi ha hagut col·lisió: reproduïm l'explosió
            batch.begin();
            batch.draw((TextureRegion) AssetManager.explosionAnim.getKeyFrame(explosionTime, false), (nau.getX() + nau.getWidth() / 2) - 32, nau.getY() + nau.getHeight() / 2 - 32, 64, 64);
            batch.end();

            explosionTime += delta;
       //     stage.getRoot().findActor("theship").remove();
        }


    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }


}
