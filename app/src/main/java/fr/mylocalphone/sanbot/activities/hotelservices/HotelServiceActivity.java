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

import fr.mylocalphone.sanbot.activities.SanbotServicesActivity;
import fr.mylocalphone.sanbot.activities.hotellaunchers.HotelLaunchersActivity;
import fr.mylocalphone.sanbot.activities.R;
import fr.mylocalphone.sanbot.activities.SanbotApp;
import fr.mylocalphone.sanbot.commons.Constants;
import fr.mylocalphone.sanbot.model.Hotel;
import fr.mylocalphone.sanbot.model.HotelServices;
import fr.mylocalphone.sanbot.model.Sanbot;

public class HotelServiceActivity extends TopBaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_service);
        final SanbotApp sanbotApp = new SanbotApp(getApplication(), getWindow());
        SanbotApp.setParentIntent(getParentActivityIntent());
        sanbotApp.keepScreenAwake();
        ImageView ivHotelLogo = findViewById(R.id.ivHotelLogo);
        ivHotelLogo.setImageDrawable(Hotel.getLogo());
        int idHotelService = SanbotApp.getActivityLauncherIntent().getIntExtra("extra", -1);
        if (idHotelService == -1) {
            sanbotApp.launchActivity(HotelLaunchersActivity.class, getContext());
        }
        else {
            HotelServices.HotelService hotelService = HotelServices.returnHotelService(idHotelService);
            if(hotelService == null) {
                if(Hotel.getId() == Constants.HOTEL_ID_LA_VILLA_DES_TERNES) {
                    sanbotApp.launchActivity(HotelServices42Activity.class, getContext());
                }
                else {
                    sanbotApp.launchActivity(HotelServices32Activity.class, getContext());
                }
            }
            else {
                ImageView ivHotelService = findViewById(R.id.imageView1);
                ivHotelService.setImageDrawable(hotelService.picture);
                TextView tvHotelService = findViewById(R.id.textView1);
                tvHotelService.setText(hotelService.content);
            }
        }
        FloatingActionButton fabBack = findViewById(R.id.fabBack);
        fabBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                if (Hotel.getId() == Constants.HOTEL_ID_LA_VILLA_DES_TERNES) {
                    sanbotApp.launchActivity(HotelServices42Activity.class, getContext());
                }
                else {
                    sanbotApp.launchActivity(HotelServices32Activity.class, getContext());
                }
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
