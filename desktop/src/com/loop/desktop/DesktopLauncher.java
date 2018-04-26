package com.loop.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.loop.Main;
import com.loop.utils.Settings;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Looping";
		config.width = Settings.GAME_WIDTH * 2;
		config.height = Settings.GAME_HEIGHT * 2;
		new LwjglApplication(new Main(), config);

	}
}
