package fr.mylocalphone.sanbot.activities.weather;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import com.qihancloud.opensdk.base.TopBaseActivity;
import com.qihancloud.opensdk.beans.FuncConstant;
import com.qihancloud.opensdk.function.unit.SpeechManager;
import com.qihancloud.opensdk.function.unit.interfaces.hardware.PIRListener;

import fr.mylocalphone.sanbot.activities.SanbotServicesActivity;
import fr.mylocalphone.sanbot.activities.R;
import fr.mylocalphone.sanbot.activities.SanbotApp;
import fr.mylocalphone.sanbot.model.Hotel;
import fr.mylocalphone.sanbot.model.Sanbot;

public class WeatherActivity extends TopBaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        final SanbotApp sanbotApp = new SanbotApp(getApplication(), getWindow());
        sanbotApp.keepScreenAwake();
        SanbotApp.setParentIntent(getParentActivityIntent());
        ImageView ivHotelLogo = findViewById(R.id.ivHotelLogo);
        ivHotelLogo.setImageDrawable(Hotel.getLogo());

        WebView wvWeather = findViewById(R.id.wvWeather);
        wvWeather.setWebViewClient(new WebViewClient());
        WebSettings webSettings = wvWeather.getSettings();
        webSettings.setJavaScriptEnabled(true);
        wvWeather.loadUrl(Hotel.geteInfos().weather);

        FloatingActionButton fabBack = findViewById(R.id.fabBack);
        fabBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                sanbotApp.launchActivity(SanbotServicesActivity.class, getContext());
            }
        });
        FloatingActionButton fabHome = findViewById(R.id.fabHome);
        fabHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                sanbotApp.launchActivity(SanbotServicesActivity.class, getContext());
            }
        });

    }

    @Override
    protected void onMainServiceConnected() {
        Sanbot.unableSystemReturnButton(getClass().getName());
        Sanbot.say("Weather in Paris", 50);
        Sanbot.setSpeechManager((SpeechManager) getUnitManager(FuncConstant.SPEECH_MANAGER));
        Sanbot.getHardWareManager().setOnHareWareListener(new PIRListener() {
            @Override
            public void onPIRCheckResult(boolean b, int i) {
                Sanbot.getSpeechManager().doWakeUp();
            }
        });
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

}
