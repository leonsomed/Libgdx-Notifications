package com.leonziyo.notifications;

import com.badlogic.gdx.backends.iosrobovm.IOSApplication;
import com.badlogic.gdx.backends.iosrobovm.IOSApplicationConfiguration;

import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.uikit.UIApplication;

public class IOSLauncher extends IOSApplication.Delegate {
    @Override
    protected IOSApplication createApplication() {
        IOSApplicationConfiguration config = new IOSApplicationConfiguration();

        // This is your ApplicationListener or Game class
        // it will be called differently depending on what you
        // set up when you created the libgdx project
        MainGame game = new MainGame();

        // We instantiate the iOS Adapter
        AdapterIOS adapter = new AdapterIOS();

        // We set the handler, you must create this method in your class
        game.setNotificationHandler(adapter);

        return new IOSApplication(game, config);
    }

    public static void main(String[] argv) {
        NSAutoreleasePool pool = new NSAutoreleasePool();
        UIApplication.main(argv, null, IOSLauncher.class);
        pool.close();
    }
}