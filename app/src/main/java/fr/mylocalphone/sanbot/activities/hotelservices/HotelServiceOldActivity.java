package fr.mylocalphone.sanbot.activities.hotelservices;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.qihancloud.opensdk.base.TopBaseActivity;
import com.qihancloud.opensdk.beans.FuncConstant;
import com.qihancloud.opensdk.function.unit.SpeechManager;
import com.qihancloud.opensdk.function.unit.SystemManager;

import fr.mylocalphone.sanbot.activities.SanbotServicesActivity;
import fr.mylocalphone.sanbot.commons.Constants;
import fr.mylocalphone.sanbot.model.Hotel;
import fr.mylocalphone.sanbot.model.HotelServices;
import fr.mylocalphone.sanbot.rao.SanbotRAO;
import fr.mylocalphone.sanbot.activities.R;
import fr.mylocalphone.sanbot.activities.SanbotApp;

public class HotelServiceOldActivity extends TopBaseActivity {

    public static final String EXTRA_BREAKFAST          = "fr.mylocalphone.sanbot.activities.hotelservices.BREAKFAST";
    public static final String EXTRA_HONESTY_BAR        = "fr.mylocalphone.sanbot.activities.hotelservices.HONESTYBAR";
    public static final String EXTRA_WIFI               = "fr.mylocalphone.sanbot.activities.hotelservices.WIFI";
    public static final String EXTRA_MEETING_ROOM       = "fr.mylocalphone.sanbot.activities.hotelservices.MEETINGROOM";
    public static final String EXTRA_EXTRA_AMENITIES    = "fr.mylocalphone.sanbot.activities.hotelservices.EXTRAAMENITIES";
    public static final String EXTRA_CONCIERGE          = "fr.mylocalphone.sanbot.activities.hotelservices.CONCIERGE";
    public static final String EXTRA_MYLOCALPHONE       = "fr.mylocalphone.sanbot.activities.hotelservices.MYLOCALPHONE";
    public static final String EXTRA_SPA                = "fr.mylocalphone.sanbot.activities.hotelservices.SPA";
    public static final String EXTRA_CON_EXTRA_AME      = "fr.mylocalphone.sanbot.activities.hotelservices.CON_EXTRA_AME";

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        final SanbotApp sanbotApp = new SanbotApp(getApplication(), getWindow());
        sanbotApp.keepScreenAwake();

        SanbotApp.setParentIntent(getParentActivityIntent());

        displayHotelService();

    }

    @Override
    protected void onMainServiceConnected() {
        SanbotApp sanbotApp = new SanbotApp();
        SanbotRAO sanbotRAO = new SanbotRAO();
        sanbotRAO.setSpeechManager((SpeechManager)getUnitManager(FuncConstant.SPEECH_MANAGER));
        sanbotRAO.setSystemManager((SystemManager)getUnitManager(FuncConstant.SYSTEM_MANAGER));
        sanbotRAO.unableSystemReturnButton(getClass().getName());

        switch (sanbotApp.getIntentStringExtra()) {

            case EXTRA_BREAKFAST :
                sanbotRAO.say(HotelServices.returnHotelService(Constants.SERVICE_ID_BREAKFAST).content, 50);
                break;

            case EXTRA_HONESTY_BAR :
                sanbotRAO.say(HotelServices.returnHotelService(Constants.SERVICE_ID_HONESTY_BAR).content, 50);
                break;

            case EXTRA_WIFI :
                sanbotRAO.say(HotelServices.returnHotelService(Constants.SERVICE_ID_WIFI).content, 50);
                break;

            case EXTRA_MEETING_ROOM :
                sanbotRAO.say(HotelServices.returnHotelService(Constants.SERVICE_ID_MEETING_ROOM).content, 50);
                break;

            case EXTRA_CONCIERGE :
                sanbotRAO.say(HotelServices.returnHotelService(Constants.SERVICE_ID_CONCIERGE).content, 50);
                break;

            case EXTRA_EXTRA_AMENITIES :
                sanbotRAO.say(HotelServices.returnHotelService(Constants.SERVICE_ID_EXTRA_AMENITIES).content, 50);
                break;

            case EXTRA_SPA :
                sanbotRAO.say(HotelServices.returnHotelService(Constants.SERVICE_ID_SPA).content, 50);
                break;

            case EXTRA_MYLOCALPHONE :
                sanbotRAO.say(HotelServices.returnHotelService(Constants.SERVICE_ID_MYLOCALPHONE).content, 50);
                break;

            case EXTRA_CON_EXTRA_AME :
                sanbotRAO.say(HotelServices.returnHotelService(Constants.SERVICE_ID_CONCIERGE_EXTRA_AMENITIES).content, 50);
                break;

            default :
                break;
        }

    }

    private void displayHotelService() {

        SanbotApp sanbotApp = new SanbotApp();
        setContentView(R.layout.activity_hotel_service_old);
        ImageView imgvHotelLogo = findViewById(R.id.imgvHotelLogo);
        imgvHotelLogo.setImageDrawable(Hotel.getLogo());
        TextView txtvHotelServiceTitle = findViewById(R.id.txtvHotelServiceTitle);
        TextView txtvHotelServiceContent1 = findViewById(R.id.txtvHotelServiceContent1);

        switch (sanbotApp.getIntentStringExtra()) {

            case EXTRA_BREAKFAST :
                getWindow().setBackgroundDrawable(HotelServices.returnHotelService(Constants.SERVICE_ID_BREAKFAST).picture);
                txtvHotelServiceTitle.setText(HotelServices.returnHotelService(Constants.SERVICE_ID_BREAKFAST).name);
                txtvHotelServiceContent1.setText(HotelServices.returnHotelService(Constants.SERVICE_ID_BREAKFAST).content);
                break;

            case EXTRA_HONESTY_BAR :
                getWindow().setBackgroundDrawable(HotelServices.returnHotelService(Constants.SERVICE_ID_HONESTY_BAR).picture);
                txtvHotelServiceTitle.setText(HotelServices.returnHotelService(Constants.SERVICE_ID_HONESTY_BAR).name);
                txtvHotelServiceContent1.setText(HotelServices.returnHotelService(Constants.SERVICE_ID_HONESTY_BAR).content);
                break;

            case EXTRA_WIFI :
                getWindow().setBackgroundDrawable(HotelServices.returnHotelService(Constants.SERVICE_ID_WIFI).picture);
                txtvHotelServiceTitle.setText(HotelServices.returnHotelService(Constants.SERVICE_ID_WIFI).name);
                txtvHotelServiceContent1.setText(HotelServices.returnHotelService(Constants.SERVICE_ID_WIFI).content);
                break;

            case EXTRA_MEETING_ROOM :
                getWindow().setBackgroundDrawable(HotelServices.returnHotelService(Constants.SERVICE_ID_MEETING_ROOM).picture);
                txtvHotelServiceTitle.setText(HotelServices.returnHotelService(Constants.SERVICE_ID_MEETING_ROOM).name);
                txtvHotelServiceContent1.setText(HotelServices.returnHotelService(Constants.SERVICE_ID_MEETING_ROOM).content);
                break;

            case EXTRA_CONCIERGE :
                getWindow().setBackgroundDrawable(HotelServices.returnHotelService(Constants.SERVICE_ID_CONCIERGE).picture);
                txtvHotelServiceTitle.setText(HotelServices.returnHotelService(Constants.SERVICE_ID_CONCIERGE).name);
                txtvHotelServiceContent1.setText(HotelServices.returnHotelService(Constants.SERVICE_ID_CONCIERGE).content);
                break;

            case EXTRA_EXTRA_AMENITIES :
                getWindow().setBackgroundDrawable(HotelServices.returnHotelService(Constants.SERVICE_ID_EXTRA_AMENITIES).picture);
                txtvHotelServiceTitle.setText(HotelServices.returnHotelService(Constants.SERVICE_ID_EXTRA_AMENITIES).name);
                txtvHotelServiceContent1.setText(HotelServices.returnHotelService(Constants.SERVICE_ID_EXTRA_AMENITIES).content);
                break;

            case EXTRA_SPA :
                getWindow().setBackgroundDrawable(HotelServices.returnHotelService(Constants.SERVICE_ID_SPA).picture);
                txtvHotelServiceTitle.setText(HotelServices.returnHotelService(Constants.SERVICE_ID_SPA).name);
                txtvHotelServiceContent1.setText(HotelServices.returnHotelService(Constants.SERVICE_ID_SPA).content);
                break;

            case EXTRA_MYLOCALPHONE :
                getWindow().setBackgroundDrawable(HotelServices.returnHotelService(Constants.SERVICE_ID_MYLOCALPHONE).picture);
                txtvHotelServiceContent1.setText(HotelServices.returnHotelService(Constants.SERVICE_ID_MYLOCALPHONE).content);
                break;

            case EXTRA_CON_EXTRA_AME :
                getWindow().setBackgroundDrawable(HotelServices.returnHotelService(Constants.SERVICE_ID_CONCIERGE_EXTRA_AMENITIES).picture);
                txtvHotelServiceTitle.setText(HotelServices.returnHotelService(Constants.SERVICE_ID_CONCIERGE_EXTRA_AMENITIES).name);
                txtvHotelServiceContent1.setText(HotelServices.returnHotelService(Constants.SERVICE_ID_CONCIERGE_EXTRA_AMENITIES).content);
                break;

            default :
                break;
        }
    }

}
