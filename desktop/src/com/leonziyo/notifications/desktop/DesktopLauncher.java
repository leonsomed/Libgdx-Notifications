package com.leonziyo.notifications.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.leonziyo.notifications.MainGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();


        MainGame game = new MainGame();
        AdapterDesktop adapter = new AdapterDesktop();

        game.setNotificationHandler(adapter);

        new LwjglApplication(game, config);
	}
}
