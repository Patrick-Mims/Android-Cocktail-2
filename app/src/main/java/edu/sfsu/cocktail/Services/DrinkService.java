package edu.sfsu.cocktail.Services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class DrinkService extends Service {

    /**
     *
     * @param intent
     * @param flags
     * @param startId
     * @return
     *
     * The onStartCommand method is executed each time a component uses the startService
     * method to start this service. As a result, it's a good place ot put code that
     * may need to be executed multiple times.
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}