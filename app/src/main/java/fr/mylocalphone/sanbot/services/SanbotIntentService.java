package fr.mylocalphone.sanbot.services;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.media.MediaPlayer;

import fr.mylocalphone.sanbot.activities.R;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class SanbotIntentService extends IntentService {
    private static Intent serviceIntent;

    private static MediaPlayer mediaPlayer;

    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_PLAYING_MUSIC = "fr.mylocalphone.sanbot.services.action.PLAYING_MUSIC";
    private static final String ACTION_BAZ = "fr.mylocalphone.sanbot.services.action.BAZ";

    // TODO: Rename parameters
    private static final String EXTRA_PARAM1 = "fr.mylocalphone.sanbot.services.extra.PARAM1";
    private static final String EXTRA_PARAM2 = "fr.mylocalphone.sanbot.services.extra.PARAM2";

    public SanbotIntentService() {
        super("SanbotIntentService");
    }

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startPlayingMusic(Context context) {
        Intent intent = new Intent(context, SanbotIntentService.class);
        intent.setAction(ACTION_PLAYING_MUSIC);
        //intent.putExtra(EXTRA_PARAM1, param1);
        //intent.putExtra(EXTRA_PARAM2, param2);
        setServiceIntent(intent);
        context.startService(intent);
    }

    /**
     * Starts this service to perform action Baz with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionBaz(Context context, String param1, String param2) {
        Intent intent = new Intent(context, SanbotIntentService.class);
        intent.setAction(ACTION_BAZ);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    public static void stopMusic(Context context){
        if(SanbotIntentService.getMediaPlayer() != null){
            SanbotIntentService.getMediaPlayer().stop();
            context.stopService(getServiceIntent());
        }
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_PLAYING_MUSIC.equals(action)) {
                //final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                //final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handlePlayingMusic();
                try {
                    Thread.sleep(75000);
                } catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
            } else if (ACTION_BAZ.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionBaz(param1, param2);
            }
        }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handlePlayingMusic() {
        // TODO: Handle action Foo
        double i = Math.random();
        if(i <= 0.3){
            SanbotIntentService.setMediaPlayer(MediaPlayer.create(getApplicationContext(), R.raw.stayin_alive));
        }
        else if(i <= 0.6){
            SanbotIntentService.setMediaPlayer(MediaPlayer.create(getApplicationContext(), R.raw.sympathique));
        }
        else {
            SanbotIntentService.setMediaPlayer(MediaPlayer.create(getApplicationContext(), R.raw.my_way_remastered));
        }
        mediaPlayer.start();
        //throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private void handleActionBaz(String param1, String param2) {
        // TODO: Handle action Baz
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public static Intent getServiceIntent() {
        return serviceIntent;
    }

    public static void setServiceIntent(Intent serviceIntent) {
        SanbotIntentService.serviceIntent = serviceIntent;
    }

    public static MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public static void setMediaPlayer(MediaPlayer mediaPlayer) {
        SanbotIntentService.mediaPlayer = mediaPlayer;
    }


}
