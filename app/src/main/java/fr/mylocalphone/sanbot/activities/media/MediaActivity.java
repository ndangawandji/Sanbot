package fr.mylocalphone.sanbot.activities.media;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.qihancloud.opensdk.base.TopBaseActivity;
import com.qihancloud.opensdk.beans.FuncConstant;
import com.qihancloud.opensdk.function.beans.speech.Grammar;
import com.qihancloud.opensdk.function.unit.SpeechManager;
import com.qihancloud.opensdk.function.unit.interfaces.hardware.PIRListener;
import com.qihancloud.opensdk.function.unit.interfaces.speech.RecognizeListener;

import fr.mylocalphone.sanbot.activities.R;
import fr.mylocalphone.sanbot.activities.SanbotApp;
import fr.mylocalphone.sanbot.activities.SanbotServicesActivity;
import fr.mylocalphone.sanbot.model.Hotel;
import fr.mylocalphone.sanbot.model.Sanbot;

public class MediaActivity extends TopBaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);
        final SanbotApp sanbotApp = new SanbotApp(getApplication(), getWindow());
        sanbotApp.keepScreenAwake();
        SanbotApp.setParentIntent(getParentActivityIntent());
        ImageView ivHotelLogo = findViewById(R.id.ivHotelLogo);
        ivHotelLogo.setImageDrawable(Hotel.getLogo());
        final MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.stayin_alive);
        mediaPlayer.start();
        ImageButton ibStopMusic = findViewById(R.id.ibStopMusic);
        ibStopMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                SanbotApp.launchActivity(SanbotServicesActivity.class, getContext());
            }
        });
    }

    @Override
    protected void onMainServiceConnected() {
        Sanbot.unableSystemReturnButton(getClass().getName());
        Sanbot.setSpeechManager((SpeechManager) getUnitManager(FuncConstant.SPEECH_MANAGER));
        Sanbot.getHardWareManager().setOnHareWareListener(new PIRListener() {
            @Override
            public void onPIRCheckResult(boolean b, int i) {
                Sanbot.getSpeechManager().doWakeUp();
            }
        });
        Sanbot.getSpeechManager().setOnSpeechListener(new RecognizeListener() {
            @Override
            public boolean onRecognizeResult(Grammar grammar) {
                if(grammar.getText().contains("Stop") || grammar.getText().contains("stop")){

                }
                else if((grammar.getText().contains("Turn") || grammar.getText().contains("turn"))
                        && grammar.getText().contains("off")){

                }
                return false;
            }

            @Override
            public void onRecognizeVolume(int i) {

            }
        });
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
