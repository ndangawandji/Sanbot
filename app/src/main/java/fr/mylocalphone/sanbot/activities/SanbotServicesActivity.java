package fr.mylocalphone.sanbot.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.qihancloud.opensdk.base.TopBaseActivity;
import com.qihancloud.opensdk.beans.FuncConstant;
import com.qihancloud.opensdk.function.unit.SpeechManager;
import com.qihancloud.opensdk.function.unit.interfaces.hardware.PIRListener;

import fr.mylocalphone.sanbot.activities.getaroundinparis.GetAroundInParisActivity;
import fr.mylocalphone.sanbot.activities.hotelservices.HotelServices32Activity;
import fr.mylocalphone.sanbot.activities.hotelservices.HotelServices42Activity;
import fr.mylocalphone.sanbot.activities.paris.Paris;
import fr.mylocalphone.sanbot.activities.restaurantbarbakery.RestaurantBarBakeryActivity;
import fr.mylocalphone.sanbot.activities.talktome.TalkToMeActivity;
import fr.mylocalphone.sanbot.activities.weather.WeatherActivity;
import fr.mylocalphone.sanbot.commons.Constants;
import fr.mylocalphone.sanbot.model.Hotel;
import fr.mylocalphone.sanbot.model.Sanbot;


public class SanbotServicesActivity extends TopBaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sanbot_services);
        final SanbotApp sanbotApp = new SanbotApp(getApplication(), getWindow());
        //Intent intentTalkToMeService = new Intent(this, TalkToMe1Service.class);
        //startService(intentTalkToMeService);
        SanbotApp.setParentIntent(getParentActivityIntent());
        sanbotApp.keepScreenAwake();
        ImageView ivHotelLogo = findViewById(R.id.ivHotelLogo);
        ivHotelLogo.setImageDrawable(Hotel.getLogo());

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        /*
        final FloatingActionButton fabFrench = findViewById(R.id.fabFrench);
        fabFrench.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                int result = 1; //sanbotApp.changeLocale(SanbotApp.FRENCH_LANGUAGE);
                getContext().getResources().getConfiguration().setLocale(new Locale(Locale.ENGLISH.getLanguage()));
                if(result == 1) {
                    //recreate();
                    sanbotApp.launchActivity(HotelLaunchersActivity.class, getContext());
                    fabFrench.setImageResource(R.mipmap.ico_english_language);
                }
            }
        });
        */


        /*
        FloatingActionButton fabBack = findViewById(R.id.fabBack);
        fabBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                sanbotApp.launchActivity(HotelLaunchersActivity.class, getContext());
            }
        });
        FloatingActionButton fabHome = findViewById(R.id.fabHome);
        fabHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                //sanbotApp.launchActivity(HotelServicesActivity.class, getContext());
            }
        });

        FloatingActionButton fabEnglish = findViewById(R.id.fabEnglish);
        fabEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                int result = sanbotApp.changeLocale(SanbotApp.ENGLISH_LANGUAGE);
                if(result == 1) {
                    //recreate();
                    sanbotApp.launchActivity(HotelLaunchersActivity.class, getContext());
                }
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        */
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
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    /*
    @Override
    protected void onStart() {
        super.onStart();
        bindService(SanbotApp.getServiceLauncherIntent(), mConnection, Context.BIND_AUTO_CREATE);
    }

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            SanbotApp.setmService(new Messenger(iBinder));
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
    */

    public void launchHotelServices(View view) {
        SanbotApp sanbotApp = new SanbotApp();
        //HotelServices.
        if(Hotel.getId() == Constants.HOTEL_ID_LA_VILLA_DES_TERNES) {
            sanbotApp.launchActivity(HotelServices42Activity.class, getContext());
        }
        else {
            sanbotApp.launchActivity(HotelServices32Activity.class, getContext());
        }
    }

    public void launchWeather(View view) {
        SanbotApp sanbotApp = new SanbotApp();
        sanbotApp.launchActivity(WeatherActivity.class, getContext());
    }

    public void launchGetAroundInParis(View view) {
        SanbotApp sanbotApp = new SanbotApp();
        sanbotApp.launchActivity(GetAroundInParisActivity.class, getContext());
    }

    public void launchRestaurantBarBakery(View view) {
        SanbotApp sanbotApp = new SanbotApp();
        sanbotApp.launchActivity(RestaurantBarBakeryActivity.class, getContext());
    }

    public void launchParis(View view) {
        SanbotApp sanbotApp = new SanbotApp();
        sanbotApp.launchActivity(Paris.class, getContext());
    }

    public void launchTalkToMe(View view) {
        SanbotApp sanbotApp = new SanbotApp();
        sanbotApp.launchActivity(TalkToMeActivity.class, getContext());
    }
}
