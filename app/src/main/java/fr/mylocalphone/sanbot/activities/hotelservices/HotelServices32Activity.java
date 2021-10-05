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
import fr.mylocalphone.sanbot.commons.Constants;
import fr.mylocalphone.sanbot.model.Hotel;
import fr.mylocalphone.sanbot.model.HotelServices;
import fr.mylocalphone.sanbot.model.Sanbot;

public class HotelServices32Activity extends TopBaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_services32);

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

        CardView cv5 = findViewById(R.id.cv5);
        CardView cv6 = findViewById(R.id.cv6);
        switch (Hotel.getId()){
            case Constants.HOTEL_ID_ACACIAS_ETOILE :
                hotelService = HotelServices.returnHotelService(Constants.SERVICE_ID_EXTRA_AMENITIES);
                ivHotelService = findViewById(R.id.imageView5);
                ivHotelService.setImageDrawable(hotelService.picture);
                tvHotelService = findViewById(R.id.textView5);
                tvHotelService.setText(hotelService.name);
                cv5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        launchHotelService(Constants.SERVICE_ID_EXTRA_AMENITIES);
                    }
                });

                hotelService = HotelServices.returnHotelService(Constants.SERVICE_ID_CONCIERGE);
                ivHotelService = findViewById(R.id.imageView6);
                ivHotelService.setImageDrawable(hotelService.picture);
                tvHotelService = findViewById(R.id.textView6);
                tvHotelService.setText(hotelService.name);
                cv6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        launchHotelService(Constants.SERVICE_ID_CONCIERGE);
                    }
                });
                break;
            case Constants.HOTEL_ID_LES_JARDINS_DE_LA_VILLA :
                hotelService = HotelServices.returnHotelService(Constants.SERVICE_ID_SPA);
                ivHotelService = findViewById(R.id.imageView5);
                ivHotelService.setImageDrawable(hotelService.picture);
                tvHotelService = findViewById(R.id.textView5);
                tvHotelService.setText(hotelService.name);
                cv5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        launchHotelService(Constants.SERVICE_ID_SPA);
                    }
                });

                hotelService = HotelServices.returnHotelService(Constants.SERVICE_ID_CONCIERGE_EXTRA_AMENITIES);
                ivHotelService = findViewById(R.id.imageView6);
                ivHotelService.setImageDrawable(hotelService.picture);
                tvHotelService = findViewById(R.id.textView6);
                tvHotelService.setText(hotelService.name);
                cv6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        launchHotelService(Constants.SERVICE_ID_CONCIERGE_EXTRA_AMENITIES);
                    }
                });
                break;
            case Constants.HOTEL_ID_MAGDA_CHAMPS_ELYSEES :
                hotelService = HotelServices.returnHotelService(Constants.SERVICE_ID_MYLOCALPHONE);
                ivHotelService = findViewById(R.id.imageView5);
                ivHotelService.setImageDrawable(hotelService.picture);
                tvHotelService = findViewById(R.id.textView5);
                tvHotelService.setText(hotelService.name);
                cv5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        launchHotelService(Constants.SERVICE_ID_MYLOCALPHONE);
                    }
                });

                hotelService = HotelServices.returnHotelService(Constants.SERVICE_ID_CONCIERGE_EXTRA_AMENITIES);
                ivHotelService = findViewById(R.id.imageView6);
                ivHotelService.setImageDrawable(hotelService.picture);
                tvHotelService = findViewById(R.id.textView6);
                tvHotelService.setText(hotelService.name);
                cv6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        launchHotelService(Constants.SERVICE_ID_CONCIERGE_EXTRA_AMENITIES);
                    }
                });
                break;
            default :
                break;
        }

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
