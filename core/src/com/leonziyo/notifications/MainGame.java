package com.leonziyo.notifications;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainGame extends ApplicationAdapter {

    SpriteBatch batch;
	Texture img;

    // This is the notificatino handler
    public NotificationHandler notificationHandler;

    @Override
	public void create () {
        // Do whatever you do when your game is created
        // ...

		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {

		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();

        // This is just an example but you
        // can now send notifications in your project
        if(Gdx.input.justTouched())
            notificationHandler.showNotification("Title", "Content");
	}

    @Override
    public void dispose() {
        batch.dispose();
    }

    // This is the method we created to set the notifications handler
    public void setNotificationHandler(NotificationHandler handler) {
        this.notificationHandler = handler;
    }
}
