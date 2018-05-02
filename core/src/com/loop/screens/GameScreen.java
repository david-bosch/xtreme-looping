package com.loop.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.loop.control.Control;
import com.loop.objects.ScrollHandler;
import com.loop.objects.Ship;
import com.loop.utils.Settings;

/**
 * Created by infot on 24/04/18.
 */

public class GameScreen implements Screen {


    private ShapeRenderer shapeRenderer;
    private Batch batch;
    Control control = new Control();
    public Stage stage;
    public Ship nau=control.getNau();


    public GameScreen(){
        shapeRenderer = new ShapeRenderer();


        OrthographicCamera camera = new OrthographicCamera(Settings.GAME_WIDTH, Settings.GAME_HEIGHT);

        camera.setToOrtho(true);
        StretchViewport viewport = new StretchViewport(Settings.GAME_WIDTH, Settings.GAME_HEIGHT , camera);
        stage = new Stage(viewport);
        batch = stage.getBatch();


        ScrollHandler scroller=new ScrollHandler();

        stage.addActor(scroller);
        stage.addActor(control);
        control.setPosition(190, 90);
        Gdx.input.setInputProcessor(stage);



        stage.addActor(nau);



    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {


            stage.draw();
            stage.act(delta);

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
