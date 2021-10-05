package fr.mylocalphone.sanbot.activities.hotelservices;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.qihancloud.opensdk.base.TopBaseActivity;
import com.qihancloud.opensdk.beans.FuncConstant;
import com.qihancloud.opensdk.function.unit.SpeechManager;
import com.qihancloud.opensdk.function.unit.SystemManager;

import fr.mylocalphone.sanbot.activities.SanbotServicesActivity;
import fr.mylocalphone.sanbot.commons.Constants;
import fr.mylocalphone.sanbot.model.HotelServices;
import fr.mylocalphone.sanbot.model.Hotel;
import fr.mylocalphone.sanbot.rao.SanbotRAO;
import fr.mylocalphone.sanbot.activities.R;
import fr.mylocalphone.sanbot.activities.SanbotApp;

public class HotelServicesOldActivity extends TopBaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        final SanbotApp sanbotApp = new SanbotApp(getApplication(), getWindow());
        sanbotApp.keepScreenAwake();

        SanbotApp.setParentIntent(getParentActivityIntent());

        displayHotelServicesMenu();

    }

    @Override
    protected void onMainServiceConnected() {

        SanbotRAO sanbotRAO = new SanbotRAO();
        sanbotRAO.setSpeechManager((SpeechManager)getUnitManager(FuncConstant.SPEECH_MANAGER));
        sanbotRAO.setSystemManager((SystemManager)getUnitManager(FuncConstant.SYSTEM_MANAGER));
        sanbotRAO.unableSystemReturnButton(getClass().getName());

        sanbotRAO.say("Hotel services", 50);

    }


    private void displayHotelServicesMenu() {

        final SanbotApp sanbotApp = new SanbotApp();
        setContentView(R.layout.activity_hotel_services_old);
        ImageView imgvHotelLogo = findViewById(R.id.imgvHotelLogo);
        imgvHotelLogo.setImageDrawable(Hotel.getLogo());

        Button bBreakfastHotelService = findViewById(R.id.bLaunchBreakfastHotelService);
        bBreakfastHotelService.setBackground(HotelServices.returnHotelService(Constants.SERVICE_ID_BREAKFAST).picture);
        bBreakfastHotelService.setText(HotelServices.returnHotelService(Constants.SERVICE_ID_BREAKFAST).name);
        bBreakfastHotelService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sanbotApp.launchActivityWithStringExtra(HotelServiceOldActivity.class, getContext(), HotelServiceOldActivity.EXTRA_BREAKFAST);
            }
        });
        Button bWifiHotelService = findViewById(R.id.bLaunchWifiHotelService);
        bWifiHotelService.setBackground(HotelServices.returnHotelService(Constants.SERVICE_ID_WIFI).picture);
        bWifiHotelService.setText(HotelServices.returnHotelService(Constants.SERVICE_ID_WIFI).name);
        bWifiHotelService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sanbotApp.launchActivityWithStringExtra(HotelServiceOldActivity.class, getContext(), HotelServiceOldActivity.EXTRA_WIFI);
            }
        });
        Button bHonestyBarHotelService = findViewById(R.id.bLaunchHonestyBarHotelService);
        bHonestyBarHotelService.setBackground(HotelServices.returnHotelService(Constants.SERVICE_ID_HONESTY_BAR).picture);
        bHonestyBarHotelService.setText(HotelServices.returnHotelService(Constants.SERVICE_ID_HONESTY_BAR).name);
        bHonestyBarHotelService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sanbotApp.launchActivityWithStringExtra(HotelServiceOldActivity.class, getContext(), HotelServiceOldActivity.EXTRA_HONESTY_BAR);
            }
        });
        Button bMeetingRoomHotelService = findViewById(R.id.bLaunchMeetingRomHotelService);
        bMeetingRoomHotelService.setBackground(HotelServices.returnHotelService(Constants.SERVICE_ID_MEETING_ROOM).picture);
        bMeetingRoomHotelService.setText(HotelServices.returnHotelService(Constants.SERVICE_ID_MEETING_ROOM).name);
        bMeetingRoomHotelService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sanbotApp.launchActivityWithStringExtra(HotelServiceOldActivity.class, getContext(), HotelServiceOldActivity.EXTRA_MEETING_ROOM);
            }
        });
        Button bDynamicButtonHotelService1 = findViewById(R.id.bDynamicButtonHotelService1);
        Button bDynamicButtonHotelService2 = findViewById(R.id.bDynamicButtonHotelService2);

        switch (Hotel.getId()) {

            case Constants.HOTEL_ID_ACACIAS_ETOILE :
                bDynamicButtonHotelService1.setText(HotelServices.returnHotelService(Constants.SERVICE_ID_EXTRA_AMENITIES).name);
                //bDynamicButtonHotelService1.setBackgroundResource();
                bDynamicButtonHotelService1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sanbotApp.launchActivityWithStringExtra(HotelServiceOldActivity.class, getContext(), HotelServiceOldActivity.EXTRA_EXTRA_AMENITIES);
                    }
                });
                bDynamicButtonHotelService2.setText(HotelServices.returnHotelService(Constants.SERVICE_ID_CONCIERGE).name);
                bDynamicButtonHotelService2.setBackground(HotelServices.returnHotelService(Constants.SERVICE_ID_CONCIERGE).picture);
                bDynamicButtonHotelService2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sanbotApp.launchActivityWithStringExtra(HotelServiceOldActivity.class, getContext(), HotelServiceOldActivity.EXTRA_CONCIERGE);
                    }
                });
                break;

            case Constants.HOTEL_ID_LA_VILLA_DES_TERNES :
                Button bMyLocalPhone = new Button(getApplicationContext());
                bMyLocalPhone.setWidth(350);
                bMyLocalPhone.setHeight(300);
                //bMyLocalPhone.setText();
                bMyLocalPhone.setBackground(HotelServices.returnHotelService(Constants.SERVICE_ID_MYLOCALPHONE).picture);
                bMyLocalPhone.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sanbotApp.launchActivityWithStringExtra(HotelServiceOldActivity.class, getContext(), HotelServiceOldActivity.EXTRA_MYLOCALPHONE);
                    }
                });
                Button bSPA = new Button(getApplicationContext());
                bSPA.setWidth(350);
                bSPA.setHeight(300);
                bSPA.setText(HotelServices.returnHotelService(Constants.SERVICE_ID_SPA).name);
                bSPA.setBackground(HotelServices.returnHotelService(Constants.SERVICE_ID_SPA).picture);
                bSPA.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sanbotApp.launchActivityWithStringExtra(HotelServiceOldActivity.class, getContext(), HotelServiceOldActivity.EXTRA_SPA);
                    }
                });
                bDynamicButtonHotelService1.setText(HotelServices.returnHotelService(Constants.SERVICE_ID_EXTRA_AMENITIES).name);
                //bDynamicButtonHotelService1.setBackgroundResource();
                bDynamicButtonHotelService1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sanbotApp.launchActivityWithStringExtra(HotelServiceOldActivity.class, getContext(), HotelServiceOldActivity.EXTRA_EXTRA_AMENITIES);
                    }
                });
                bDynamicButtonHotelService2.setText(HotelServices.returnHotelService(Constants.SERVICE_ID_CONCIERGE).name);
                bDynamicButtonHotelService2.setBackground(HotelServices.returnHotelService(Constants.SERVICE_ID_CONCIERGE).picture);
                bDynamicButtonHotelService2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sanbotApp.launchActivityWithStringExtra(HotelServiceOldActivity.class, getContext(), HotelServiceOldActivity.EXTRA_CONCIERGE);
                    }
                });
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(350, 300);
                layoutParams.setMargins(8,8,8,8);
                LinearLayout llytHotelServicesMenuButtonBar1 = findViewById(R.id.llytHotelServicesMenuButtonBar1);
                llytHotelServicesMenuButtonBar1.addView(bMyLocalPhone, 2, layoutParams);
                LinearLayout llytHotelServicesMenuButtonBar2 = findViewById(R.id.llytHotelServicesMenuButtonBar2);
                llytHotelServicesMenuButtonBar2.addView(bSPA, 2, layoutParams);
                break;

            case Constants.HOTEL_ID_LES_JARDINS_DE_LA_VILLA :
                bDynamicButtonHotelService1.setText(HotelServices.returnHotelService(Constants.SERVICE_ID_SPA).name);
                bDynamicButtonHotelService1.setBackground(HotelServices.returnHotelService(Constants.SERVICE_ID_SPA).picture);
                bDynamicButtonHotelService1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sanbotApp.launchActivityWithStringExtra(HotelServiceOldActivity.class, getContext(), HotelServiceOldActivity.EXTRA_SPA);
                    }
                });
                bDynamicButtonHotelService2.setText(HotelServices.returnHotelService(Constants.SERVICE_ID_CONCIERGE_EXTRA_AMENITIES).name);
                //bDynamicButtonHotelService2.setBackgroundResource(hotel.getHotelService(HotelServiceRAO.CONCIERGE_EXTRA_AMENITIES_SERVICE_NAME).getServiceImage());
                bDynamicButtonHotelService2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sanbotApp.launchActivityWithStringExtra(HotelServiceOldActivity.class, getContext(), HotelServiceOldActivity.EXTRA_CON_EXTRA_AME);
                    }
                });
                break;

            case Constants.HOTEL_ID_MAGDA_CHAMPS_ELYSEES :
                //bDynamicButtonHotelService1.setText();
                bDynamicButtonHotelService1.setBackground(HotelServices.returnHotelService(Constants.SERVICE_ID_MYLOCALPHONE).picture);
                bDynamicButtonHotelService1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sanbotApp.launchActivityWithStringExtra(HotelServiceOldActivity.class, getContext(), HotelServiceOldActivity.EXTRA_MYLOCALPHONE);
                    }
                });
                bDynamicButtonHotelService2.setText(HotelServices.returnHotelService(Constants.SERVICE_ID_CONCIERGE_EXTRA_AMENITIES).name);
                //bDynamicButtonHotelService2.setBackgroundResource(hotel.getHotelService(HotelServiceRAO.CONCIERGE_EXTRA_AMENITIES_SERVICE_NAME).getServiceImage());
                bDynamicButtonHotelService2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sanbotApp.launchActivityWithStringExtra(HotelServiceOldActivity.class, getContext(), HotelServiceOldActivity.EXTRA_CON_EXTRA_AME);
                    }
                });
                break;

            default:
                imgvHotelLogo.setImageResource(R.drawable.three_stars);
                break;
        }

    }


}
