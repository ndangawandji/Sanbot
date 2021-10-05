package fr.mylocalphone.sanbot.activities.hotelservices;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import com.qihancloud.opensdk.base.TopBaseActivity;
import com.qihancloud.opensdk.beans.FuncConstant;
import com.qihancloud.opensdk.function.unit.SpeechManager;
import com.qihancloud.opensdk.function.unit.interfaces.hardware.PIRListener;

import fr.mylocalphone.sanbot.activities.R;
import fr.mylocalphone.sanbot.activities.SanbotApp;
import fr.mylocalphone.sanbot.activities.SanbotServicesActivity;
import fr.mylocalphone.sanbot.activities.hotellaunchers.HotelLaunchersActivity;
import fr.mylocalphone.sanbot.commons.Constants;
import fr.mylocalphone.sanbot.model.Hotel;
import fr.mylocalphone.sanbot.model.HotelServices;
import fr.mylocalphone.sanbot.model.Sanbot;

public class HotelServices42Activity extends TopBaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_services42);

        final SanbotApp sanbotApp = new SanbotApp(getApplication(), getWindow());
        SanbotApp.setParentIntent(getParentActivityIntent());

        sanbotApp.keepScreenAwake();
        ImageView ivHotelLogo = findViewById(R.id.ivHotelLogo);
        ivHotelLogo.setImageDrawable(Hotel.getLogo());

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

        HotelServices.HotelService hotelService = HotelServices.returnHotelService(Constants.SERVICE_ID_BREAKFAST);
        ImageView ivHotelService = findViewById(R.id.imageView1);
        ivHotelService.setImageDrawable(hotelService.picture);
        TextView tvHotelService = findViewById(R.id.textView1);
        tvHotelService.setText(hotelService.name);

        hotelService = HotelServices.returnHotelService(Constants.SERVICE_ID_HONESTY_BAR);
        ivHotelService = findViewById(R.id.imageView2);
        ivHotelService.setImageDrawable(hotelService.picture);
        tvHotelService = findViewById(R.id.textView2);
        tvHotelService.setText(hotelService.name);

        hotelService = HotelServices.returnHotelService(Constants.SERVICE_ID_WIFI);
        ivHotelService = findViewById(R.id.imageView3);
        ivHotelService.setImageDrawable(hotelService.picture);
        tvHotelService = findViewById(R.id.textView3);
        tvHotelService.setText(hotelService.name);

        hotelService = HotelServices.returnHotelService(Constants.SERVICE_ID_MEETING_ROOM);
        ivHotelService = findViewById(R.id.imageView4);
        ivHotelService.setImageDrawable(hotelService.picture);
        tvHotelService = findViewById(R.id.textView4);
        tvHotelService.setText(hotelService.name);

        hotelService = HotelServices.returnHotelService(Constants.SERVICE_ID_SPA);
        ivHotelService = findViewById(R.id.imageView5);
        ivHotelService.setImageDrawable(hotelService.picture);
        tvHotelService = findViewById(R.id.textView5);
        tvHotelService.setText(hotelService.name);

        hotelService = HotelServices.returnHotelService(Constants.SERVICE_ID_MYLOCALPHONE);
        ivHotelService = findViewById(R.id.imageView6);
        ivHotelService.setImageDrawable(hotelService.picture);
        tvHotelService = findViewById(R.id.textView6);
        tvHotelService.setText(hotelService.name);

        hotelService = HotelServices.returnHotelService(Constants.SERVICE_ID_CONCIERGE);
        ivHotelService = findViewById(R.id.imageView7);
        ivHotelService.setImageDrawable(hotelService.picture);
        tvHotelService = findViewById(R.id.textView7);
        tvHotelService.setText(hotelService.name);

        hotelService = HotelServices.returnHotelService(Constants.SERVICE_ID_EXTRA_AMENITIES);
        ivHotelService = findViewById(R.id.imageView8);
        ivHotelService.setImageDrawable(hotelService.picture);
        tvHotelService = findViewById(R.id.textView8);
        tvHotelService.setText(hotelService.name);

        CardView cv1 = findViewById(R.id.cv1);
        cv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchHotelService(Constants.SERVICE_ID_BREAKFAST);
            }
        });

        CardView cv2 = findViewById(R.id.cv2);
        cv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchHotelService(Constants.SERVICE_ID_HONESTY_BAR);
            }
        });

        CardView cv3 = findViewById(R.id.cv3);
        cv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchHotelService(Constants.SERVICE_ID_WIFI);
            }
        });

        CardView cv4 = findViewById(R.id.cv4);
        cv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchHotelService(Constants.SERVICE_ID_MEETING_ROOM);
            }
        });

        CardView cv5 = findViewById(R.id.cv5);
        cv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchHotelService(Constants.SERVICE_ID_SPA);
            }
        });

        CardView cv6 = findViewById(R.id.cv6);
        cv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchHotelService(Constants.SERVICE_ID_MYLOCALPHONE);
            }
        });

        CardView cv7 = findViewById(R.id.cv7);
        cv7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchHotelService(Constants.SERVICE_ID_CONCIERGE);
            }
        });

        CardView cv8 = findViewById(R.id.cv8);
        cv8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchHotelService(Constants.SERVICE_ID_EXTRA_AMENITIES);
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
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    public void launchHotelService(int idHotelService) {
        SanbotApp.launchActivityWithIntExtra(HotelServiceActivity.class, getContext(), idHotelService);
    }
}
