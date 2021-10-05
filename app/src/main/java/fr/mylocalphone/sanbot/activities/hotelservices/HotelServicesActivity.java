package fr.mylocalphone.sanbot.activities.hotelservices;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.fragment.app.*;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import com.qihancloud.opensdk.base.TopBaseActivity;

import fr.mylocalphone.sanbot.activities.hotellaunchers.HotelLaunchersActivity;
import fr.mylocalphone.sanbot.activities.R;
import fr.mylocalphone.sanbot.activities.SanbotApp;
import fr.mylocalphone.sanbot.activities.SanbotServicesActivity;
import fr.mylocalphone.sanbot.commons.Constants;
import fr.mylocalphone.sanbot.model.Hotel;
import fr.mylocalphone.sanbot.model.HotelServices;

public class HotelServicesActivity extends TopBaseActivity implements HotelServicesFragment.OnListFragmentInteractionListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_services);
        final SanbotApp sanbotApp = new SanbotApp(getApplication(), getWindow());
        SanbotApp.setParentIntent(getParentActivityIntent());

        sanbotApp.keepScreenAwake();
        ImageView ivHotelLogo = findViewById(R.id.ivHotelLogo);
        ivHotelLogo.setImageDrawable(Hotel.getLogo());

        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        HotelServicesFragment hotelServicesFragment = null;
        switch (Hotel.getId()){
            case Constants.HOTEL_ID_ACACIAS_ETOILE :
                hotelServicesFragment = HotelServicesFragment.newInstance(3);
                break;
            case Constants.HOTEL_ID_LA_VILLA_DES_TERNES :
                hotelServicesFragment = HotelServicesFragment.newInstance(4);
                break;
            case Constants.HOTEL_ID_LES_JARDINS_DE_LA_VILLA :
                hotelServicesFragment = HotelServicesFragment.newInstance(3);
                break;
            case Constants.HOTEL_ID_MAGDA_CHAMPS_ELYSEES :
                hotelServicesFragment = HotelServicesFragment.newInstance(3);
                break;
            default :
                break;
        }
        //fragmentTransaction.add(R.id.glHotelServices, hotelServicesFragment);
        //fragmentTransaction.commit();
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
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
        FloatingActionButton fabFrench = findViewById(R.id.fabFrench);
        fabFrench.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                int result = sanbotApp.changeLocale(SanbotApp.FRENCH_LANGUAGE);
                if(result == 1) {
                    //recreate();
                    sanbotApp.launchActivity(HotelLaunchersActivity.class, getContext());
                }
            }
        });
//        FloatingActionButton fabEnglish = findViewById(R.id.fabEnglish);
//        fabEnglish.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//                int result = sanbotApp.changeLocale(SanbotApp.ENGLISH_LANGUAGE);
//                if(result == 1) {
//                    //recreate();
//                    sanbotApp.launchActivity(HotelLaunchersActivity.class, getContext());
//                }
//            }
//        });
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onMainServiceConnected() {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onListFragmentInteraction(HotelServices.HotelService item) {

    }
}
