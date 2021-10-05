package fr.mylocalphone.sanbot.activities.hotellaunchers;

import android.content.Intent;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import android.view.View;

import com.qihancloud.opensdk.base.TopBaseActivity;

import fr.mylocalphone.sanbot.activities.R;
import fr.mylocalphone.sanbot.activities.SanbotApp;
import fr.mylocalphone.sanbot.activities.SanbotServicesActivity;
import fr.mylocalphone.sanbot.commons.Constants;
import fr.mylocalphone.sanbot.model.Hotel;
import fr.mylocalphone.sanbot.services.TalkToMeService;
import fr.mylocalphone.sanbot.services.TalkToYouService;

public class HotelLaunchersActivity extends TopBaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_launchers);
        final SanbotApp sanbotApp = new SanbotApp(getApplication(), getWindow());
        setContentView(R.layout.activity_hotel_launchers);
        sanbotApp.keepScreenAwake();
        if(Hotel.getId() != -1) {
            //sanbotApp.launchActivity(SanbotServicesActivity.class, getContext());
        }
        sanbotApp.launchService(TalkToYouService.class, getContext());
        Intent intentTalkToMeService = new Intent(this, TalkToMeService.class);
        startService(intentTalkToMeService);

        CardView cvLaunchAcaciasEtoile = findViewById(R.id.cvLaunchAcaciasEtoile);
        cvLaunchAcaciasEtoile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Hotel.createHotel(Constants.HOTEL_ID_ACACIAS_ETOILE, getResources());
                sanbotApp.launchActivity(SanbotServicesActivity.class, getContext());
            }
        });

        CardView cvLaunchLaVillaDesTernes = findViewById(R.id.cvLaunchLaVillaDesTernes);
        cvLaunchLaVillaDesTernes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Hotel.createHotel(Constants.HOTEL_ID_LA_VILLA_DES_TERNES, getResources());
                sanbotApp.launchActivity(SanbotServicesActivity.class, getContext());
            }
        });

        CardView cvLaunchLesJardinsDeLaVilla = findViewById(R.id.cvLaunchLesJardinsDeLaVilla);
        cvLaunchLesJardinsDeLaVilla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Hotel.createHotel(Constants.HOTEL_ID_LES_JARDINS_DE_LA_VILLA, getResources());
                sanbotApp.launchActivity(SanbotServicesActivity.class, getContext());
            }
        });

        CardView cvLaunchMagdaChampsElysees = findViewById(R.id.cvLaunchMagdaChampsElysees);
        cvLaunchMagdaChampsElysees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Hotel.createHotel(Constants.HOTEL_ID_MAGDA_CHAMPS_ELYSEES, getResources());
                sanbotApp.launchActivity(SanbotServicesActivity.class, getContext());
            }
        });
    }

    @Override
    protected void onMainServiceConnected() {
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
