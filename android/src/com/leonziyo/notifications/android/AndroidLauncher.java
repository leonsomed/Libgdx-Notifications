package com.leonziyo.notifications.android;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.leonziyo.notifications.MainGame;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();

        AdapterAndroid adapterAndroid = new AdapterAndroid(this);
        MainGame game = new MainGame();

        game.setNotificationHandler(adapterAndroid);

        initialize(game, config);
	}
}
