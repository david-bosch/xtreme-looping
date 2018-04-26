package com.loop;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.loop.helpers.AssetManager;
import com.loop.screens.GameScreen;

public class Main extends Game {



	@Override
	public void create() {

		AssetManager.load();
		setScreen(new GameScreen());

	}
	@Override
	public void dispose(){
		super.dispose();
		AssetManager.dispose();

	}




}