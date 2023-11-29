package edu.sfsu.cocktail.Services;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;

public class DrinkService extends IntentService {
    /**
     * @param name
     * @deprecated
     */

    public static final String EXTRA_MESSAGE = "message";

    public DrinkService(String name) {
        super(name);
    }

    /**
     * The onHandleIntent() method should contain the code you want to run each time the service is passed an intent.
     * It runs in a separate thread. If it's passed multiple intents, it deals with them one at a time.
     * @param intent
     */
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        synchronized (this) {
            try {
                wait(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        String text = intent.getStringExtra(EXTRA_MESSAGE);
        showText(text);
    }

    public void showText(final String text) {
        Log.i("LOG", "I am the service");
    }
}