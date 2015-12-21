package com.naren.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.naren.game.FlappyBot;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = FlappyBot.WIDTH;
		config.height = FlappyBot.HEIGHT;
		config.title = FlappyBot.TITLE;
		new LwjglApplication(new FlappyBot(), config);
	}
}
