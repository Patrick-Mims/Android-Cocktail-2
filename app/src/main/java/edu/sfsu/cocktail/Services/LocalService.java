package edu.sfsu.cocktail.Services;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;

public class LocalService extends Service {
    private MediaPlayer player;
    private NotificationManager mNM;
    public LocalService() {
    }

    // onCreate() gets called when startService() (located in MainActivity) is called.
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("TAG","Class: LocalService  => method: onCreate()");

        mNM = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    /**
     *
     * @param intent
     * @param flags
     * @param startId
     * @return
     *
     * When startService() method is called, the onStartCommand(Intent, int, int) is called.
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("LocalService", "Received start id " + startId + ": " + intent);
        player = MediaPlayer.create(this, Settings.System.DEFAULT_ALARM_ALERT_URI);
        player.setLooping(true);
        player.start();

        /*
            For started services, there are two additional major modes of operation they can decide
            to run in, depending on the value they return from onStartCommand():
            START_STICKY is used for services that are explicitly started and stopped as needed.
        */
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        player.stop();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}