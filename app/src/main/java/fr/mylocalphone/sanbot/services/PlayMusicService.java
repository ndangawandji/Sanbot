package fr.mylocalphone.sanbot.services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import com.qihancloud.opensdk.base.BindBaseService;

import fr.mylocalphone.sanbot.activities.R;

public class PlayMusicService extends BindBaseService {
    public PlayMusicService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate(){
        super.onCreate();
        register(PlayMusicService.class);
    }

    @Override
    protected void onMainServiceConnected() {
        MediaPlayer mediaPlayer = MediaPlayer.create(getContext(), R.raw.stayin_alive);
        mediaPlayer.start();
    }
}
