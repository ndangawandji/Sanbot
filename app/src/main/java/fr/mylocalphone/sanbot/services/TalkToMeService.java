package fr.mylocalphone.sanbot.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

import com.qihancloud.opensdk.base.BindBaseService;
import com.qihancloud.opensdk.function.beans.EmotionsType;
import com.qihancloud.opensdk.function.beans.speech.Grammar;
import com.qihancloud.opensdk.function.unit.interfaces.hardware.TouchSensorListener;
import com.qihancloud.opensdk.function.unit.interfaces.speech.RecognizeListener;
import com.qihancloud.opensdk.function.unit.interfaces.speech.WakenListener;

import fr.mylocalphone.sanbot.activities.SanbotApp;
import fr.mylocalphone.sanbot.commons.Constants;
import fr.mylocalphone.sanbot.model.Hotel;
import fr.mylocalphone.sanbot.model.Sanbot;

public class TalkToMeService extends BindBaseService {

    public TalkToMeService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        register(TalkToMeService.class);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    protected void onMainServiceConnected() {
        Sanbot.unableSystemReturnButton(getClass().getName());
        final String TAG = "response";
        Sanbot.getSpeechManager().setOnSpeechListener(new RecognizeListener() {
            @Override
            public boolean onRecognizeResult(Grammar grammar) {
                Message msg = Message.obtain();
                if(grammar.getText().contains("paris") ||grammar.getText().contains("Paris")
                   || grammar.getText().contains("city") || grammar.getText().contains("City")
                   || grammar.getText().contains("town") || grammar.getText().contains("Town")) {
                    if(grammar.getText().contains("experiences") || grammar.getText().contains("Experiences")
                        || grammar.getText().contains("picture") || grammar.getText().contains("picture")
                        || grammar.getText().contains("Pictures") || grammar.getText().contains("pictures")
                        || grammar.getText().contains("Places") || grammar.getText().contains("places")
                        || grammar.getText().contains("Place") || grammar.getText().contains("place")) {
                        msg.arg1 = Constants.REQUEST_GET_AROUND_IN_PARIS;
                    }
                    else if(grammar.getText().contains("Restaurant")
                            || grammar.getText().contains("restaurant")
                            || grammar.getText().contains("Lunch") || grammar.getText().contains("lunch")
                            || grammar.getText().contains("Breakfast") || grammar.getText().contains("breakfast")
                            || grammar.getText().contains("Dining") || grammar.getText().contains("dining")
                            || grammar.getText().contains("Lunching") || grammar.getText().contains("lunching")
                            || grammar.getText().contains("Bar") || grammar.getText().contains("bar")
                            || grammar.getText().contains("Bakery") || grammar.getText().contains("bakery")
                            || grammar.getText().contains("Bakeries") || grammar.getText().contains("bakeries")
                            || grammar.getText().contains("Drink") || grammar.getText().contains("drink")
                            || grammar.getText().contains("Drinks") || grammar.getText().contains("drinks")){
                        msg.arg1 = Constants.REQUEST_RESTAURANT_BAR_BAKERY;
                    }
                    else if(grammar.getText().contains("Get around")
                            || grammar.getText().contains("get around")
                            || grammar.getText().contains("Transportation") || grammar.getText().contains("Transportations")
                            || grammar.getText().contains("transportation") || grammar.getText().contains("transportations")
                            || grammar.getText().contains("metro station") || grammar.getText().contains("Metro station")
                            || grammar.getText().contains("bus station") || grammar.getText().contains("Bus station")
                            || grammar.getText().contains("train station") || grammar.getText().contains("Train station")
                            || grammar.getText().contains("Taxi") || grammar.getText().contains("taxi")) {
                        msg.arg1 = Constants.REQUEST_GET_AROUND_IN_PARIS;
                    }
                    else if(grammar.getText().contains("weather")|| grammar.getText().contains("Weather")) {
                        msg.arg1 = Constants.REQUEST_WEATHER;
                    }
                    else {
                        msg.arg1 = Constants.REQUEST_ERROR;
                    }
                }
                else if(grammar.getText().contains("weather")|| grammar.getText().contains("Weather")) {
                    msg.arg1 = Constants.REQUEST_WEATHER;
                }
                else if(grammar.getText().contains("Transportation") || grammar.getText().contains("Transportations")
                        || grammar.getText().contains("transportation") || grammar.getText().contains("transportations")
                        || grammar.getText().contains("metro station") || grammar.getText().contains("Metro station")
                        || grammar.getText().contains("bus station") || grammar.getText().contains("Bus station")
                        || grammar.getText().contains("train station") || grammar.getText().contains("Train station")) {
                    msg.arg1 = Constants.REQUEST_GET_AROUND_IN_PARIS;
                }
                else if(grammar.getText().contains("Restaurant") || grammar.getText().contains("restaurant")
                        || grammar.getText().contains("Restaurants") || grammar.getText().contains("restaurants")
                        || grammar.getText().contains("Bakery") || grammar.getText().contains("bakery")
                        || grammar.getText().contains("lunch") || grammar.getText().contains("Lunch")
                        || grammar.getText().contains("lunching") || grammar.getText().contains("Lunching")
                        || grammar.getText().contains("Breakfast") || grammar.getText().contains("breakfast")
                        || grammar.getText().contains("Bakeries") || grammar.getText().contains("bakeries")) {
                    msg.arg1 = Constants.REQUEST_HOTEL_SERVICE_BREAKFAST;
                    msg.arg2 = Constants.SERVICE_ID_BREAKFAST;
                }
                else if(grammar.getText().contains("bar")|| grammar.getText().contains("Bar")
                        || grammar.getText().contains("Drink") || grammar.getText().contains("drink")
                        || grammar.getText().contains("Drinks") || grammar.getText().contains("drinks")) {
                    msg.arg1 = Constants.REQUEST_HOTEL_SERVICE_HONESTY_BAR;
                    msg.arg2 = Constants.SERVICE_ID_HONESTY_BAR;
                }
                else if(grammar.getText().equals("Can you speak") || grammar.getText().equals("Can you speak with me")
                        || grammar.getText().equals("What do you know to say")
                        || grammar.getText().equals("Can you talk to me")
                        || grammar.getText().equals("What words do you know")
                        || grammar.getText().equals("Tell me something")
                        || grammar.getText().equals("What words can you say")
                        || grammar.getText().contains("tell you") || grammar.getText().contains("talk to you")
                        || grammar.getText().contains("speak with you")){
                    msg.arg1 = Constants.REQUEST_TALK_TO_ME;
                }
                else if (grammar.getText().contains("meeting room")
                        || grammar.getText().contains("Meeting room")
                        || grammar.getText().contains("meeting room service")
                        || grammar.getText().contains("Meeting room service")) {
                    msg.arg1 = Constants.REQUEST_HOTEL_SERVICE_MEETING_ROOM;
                    msg.arg2 = Constants.SERVICE_ID_MEETING_ROOM;
                }
                else if (grammar.getText().contains("Wi-Fi")
                        || grammar.getText().contains("Wi-Fi service")
                        || grammar.getText().contains("internet")
                        || grammar.getText().contains("Internet")
                        || grammar.getText().contains("Internet service")
                        || grammar.getText().contains("internet service")) {
                    msg.arg1 = Constants.REQUEST_HOTEL_SERVICE_WIFI;
                    msg.arg2 = Constants.SERVICE_ID_WIFI;
                }
                else if(grammar.getText().contains("my local phone")
                        || grammar.getText().contains("My local phone")
                        || (grammar.getText().contains("Smartphone") && grammar.getText().contains("service"))
                        || (grammar.getText().contains("smartphone") && grammar.getText().contains("service"))
                        || (grammar.getText().contains("Smartphone") && grammar.getText().contains("room"))
                        || (grammar.getText().contains("smartphone") && grammar.getText().contains("room"))
                        || grammar.getText().contains("smartphone")
                        || grammar.getText().contains("room service")|| grammar.getText().contains("Room service")) {
                    msg.arg1 = Constants.REQUEST_HOTEL_SERVICE_MYLOCALPHONE;
                    msg.arg2 = Constants.SERVICE_ID_MYLOCALPHONE;
                }
                else if(grammar.getText().contains("spa") || grammar.getText().contains("Spa")
                        || grammar.getText().contains("spa service")
                        || grammar.getText().contains("Spa service")){
                    msg.arg1 = Constants.REQUEST_HOTEL_SERVICE_SPA;
                    msg.arg2 = Constants.SERVICE_ID_SPA;
                }
                else if(grammar.getText().contains("concierge") || grammar.getText().contains("Concierge")
                        || grammar.getText().contains("concierge service")
                        || grammar.getText().contains("Concierge service")){

                    if(Hotel.getId() == Constants.HOTEL_ID_LES_JARDINS_DE_LA_VILLA
                            || Hotel.getId() == Constants.HOTEL_ID_MAGDA_CHAMPS_ELYSEES){
                        msg.arg1 = Constants.REQUEST_HOTEL_SERVICE_CONCIERGE;
                        msg.arg2 = Constants.SERVICE_ID_CONCIERGE_EXTRA_AMENITIES;
                    }
                    else if(Hotel.getId() == Constants.HOTEL_ID_ACACIAS_ETOILE
                            || Hotel.getId() == Constants.HOTEL_ID_LA_VILLA_DES_TERNES){
                        msg.arg1 = Constants.REQUEST_HOTEL_SERVICE_CONCIERGE;
                        msg.arg2 = Constants.SERVICE_ID_CONCIERGE;
                    }
                    else {

                    }
                }
                else if(grammar.getText().contains("extra") || grammar.getText().contains("Extra")
                        || (grammar.getText().contains("extra") && grammar.getText().contains("service"))
                        || (grammar.getText().contains("Extra") && grammar.getText().contains("service"))
                        || grammar.getText().contains("Extra amenities")
                        || grammar.getText().contains("extra amenities")
                        || grammar.getText().contains("Extra amenities service")
                        || grammar.getText().contains("extra amenities service")){

                    if(Hotel.getId() == Constants.HOTEL_ID_LES_JARDINS_DE_LA_VILLA
                            || Hotel.getId() == Constants.HOTEL_ID_MAGDA_CHAMPS_ELYSEES){
                        msg.arg1 = Constants.REQUEST_HOTEL_SERVICE_EXTRA_AMENITIES;
                        msg.arg2 = Constants.SERVICE_ID_CONCIERGE_EXTRA_AMENITIES;

                    }
                    else if(Hotel.getId() == Constants.HOTEL_ID_ACACIAS_ETOILE
                            || Hotel.getId() == Constants.HOTEL_ID_LA_VILLA_DES_TERNES){
                        msg.arg1 = Constants.REQUEST_HOTEL_SERVICE_EXTRA_AMENITIES;
                        msg.arg2 = Constants.SERVICE_ID_EXTRA_AMENITIES;
                    }
                    else {

                    }
                }
                /*
                else if(grammar.getText().contains("hotel") || grammar.getText().contains("Hotel")){
                    if(grammar.getText().contains("service") || grammar.getText().contains("Service")
                            || grammar.getText().contains("services")
                            || grammar.getText().contains("Services")
                            || grammar.getText().contains("Offer")
                            || grammar.getText().contains("Offers")
                            || grammar.getText().contains("offer")
                            || grammar.getText().contains("offers")){
                        if(grammar.getText().contains("Breakfast")
                                || grammar.getText().contains("breakfast")){
                            msg.arg1 = Constants.REQUEST_HOTEL_SERVICE_BREAKFAST;
                            msg.arg2 = Constants.SERVICE_ID_BREAKFAST;
                        }
                        else if(grammar.getText().contains("Bar") || grammar.getText().contains("bar")
                                || grammar.getText().contains("Drink") || grammar.getText().contains("drink")){
                            msg.arg1 = Constants.REQUEST_HOTEL_SERVICE_HONESTY_BAR;
                            msg.arg2 = Constants.SERVICE_ID_HONESTY_BAR;
                        }
                        else if(grammar.getText().contains("Meeting")
                                || grammar.getText().contains("meeting")){
                            msg.arg1 = Constants.REQUEST_HOTEL_SERVICE_MEETING_ROOM;
                            msg.arg2 = Constants.SERVICE_ID_MEETING_ROOM;
                        }
                        else if(grammar.getText().contains("Wi-Fi")
                                || grammar.getText().contains("Internet")
                                || grammar.getText().contains("internet")
                                || grammar.getText().contains("network")
                                || grammar.getText().contains("Network")){
                            msg.arg1 = Constants.REQUEST_HOTEL_SERVICE_WIFI;
                            msg.arg2 = Constants.SERVICE_ID_WIFI;
                        }
                        else if(grammar.getText().contains("Smartphone")
                                || grammar.getText().contains("smartphone")
                                || grammar.getText().contains("smartphones")
                                || grammar.getText().contains("My local phone")
                                || grammar.getText().contains("my local phone")){
                            if(Hotel.getId() == Constants.HOTEL_ID_LA_VILLA_DES_TERNES
                                    || Hotel.getId() == Constants.HOTEL_ID_MAGDA_CHAMPS_ELYSEES){
                                msg.arg1 = Constants.REQUEST_HOTEL_SERVICE_MYLOCALPHONE;
                                msg.arg2 = Constants.SERVICE_ID_MYLOCALPHONE;
                            }
                            else{
                                // Request Hotel services
                            }
                        }
                        else if(grammar.getText().contains("spa")
                                || grammar.getText().contains("Spa")
                                || grammar.getText().contains("Sauna")
                                || grammar.getText().contains("sauna")
                                || grammar.getText().contains("Hammam")
                                || grammar.getText().contains("hammam")){
                            if(Hotel.getId() == Constants.HOTEL_ID_LA_VILLA_DES_TERNES
                                    || Hotel.getId() == Constants.HOTEL_ID_LES_JARDINS_DE_LA_VILLA){
                                msg.arg1 = Constants.REQUEST_HOTEL_SERVICE_SPA;
                                msg.arg2 = Constants.SERVICE_ID_SPA;
                            }
                            else {
                                // Request Hotel services
                            }
                        }
                        else if(grammar.getText().contains("Concierge")
                                || grammar.getText().contains("concierge")){
                            if(Hotel.getId() == Constants.HOTEL_ID_LES_JARDINS_DE_LA_VILLA
                                    || Hotel.getId() == Constants.HOTEL_ID_MAGDA_CHAMPS_ELYSEES){
                                msg.arg1 = Constants.REQUEST_HOTEL_SERVICE_CONCIERGE;
                                msg.arg2 = Constants.SERVICE_ID_CONCIERGE_EXTRA_AMENITIES;
                            }
                            else if(Hotel.getId() == Constants.HOTEL_ID_ACACIAS_ETOILE
                                    || Hotel.getId() == Constants.HOTEL_ID_LA_VILLA_DES_TERNES){
                                msg.arg1 = Constants.REQUEST_HOTEL_SERVICE_CONCIERGE;
                                msg.arg2 = Constants.SERVICE_ID_CONCIERGE;
                            }
                            else {
                                // Request Hotel services
                            }
                        }
                        else if(grammar.getText().contains("extra")
                                || grammar.getText().contains("Extra")){
                            if(Hotel.getId() == Constants.HOTEL_ID_LES_JARDINS_DE_LA_VILLA
                                    || Hotel.getId() == Constants.HOTEL_ID_MAGDA_CHAMPS_ELYSEES){
                                msg.arg1 = Constants.REQUEST_HOTEL_SERVICE_EXTRA_AMENITIES;
                                msg.arg2 = Constants.SERVICE_ID_CONCIERGE_EXTRA_AMENITIES;

                            }
                            else if(Hotel.getId() == Constants.HOTEL_ID_ACACIAS_ETOILE
                                    || Hotel.getId() == Constants.HOTEL_ID_LA_VILLA_DES_TERNES){
                                msg.arg1 = Constants.REQUEST_HOTEL_SERVICE_EXTRA_AMENITIES;
                                msg.arg2 = Constants.SERVICE_ID_EXTRA_AMENITIES;
                            }
                            else {
                                // Request Hotel services
                            }
                        }
                        else {
                            // Request Hotel services
                        }
                    }
                    else if(grammar.getText().contains("Breakfast")
                            || grammar.getText().contains("breakfast")){
                        if(grammar.getText().contains("around") || grammar.getText().contains("out")
                                || grammar.getText().contains("far")
                                || grammar.getText().contains("away")){
                            msg.arg1 = Constants.REQUEST_RESTAURANT_BAR_BAKERY;
                        }
                        else {
                            msg.arg1 = Constants.REQUEST_HOTEL_SERVICE_BREAKFAST;
                            msg.arg2 = Constants.SERVICE_ID_BREAKFAST;
                        }
                    }
                    else if(grammar.getText().contains("Bar") || grammar.getText().contains("bar")
                            || grammar.getText().contains("Drink")
                            || grammar.getText().contains("drink")){
                        if(grammar.getText().contains("around") || grammar.getText().contains("out")
                                || grammar.getText().contains("far")
                                || grammar.getText().contains("away")){
                            msg.arg1 = Constants.REQUEST_RESTAURANT_BAR_BAKERY;
                        }
                        else {
                            msg.arg1 = Constants.REQUEST_HOTEL_SERVICE_HONESTY_BAR;
                            msg.arg2 = Constants.SERVICE_ID_HONESTY_BAR;
                        }
                    }
                    else if(grammar.getText().contains("Meeting")
                            || grammar.getText().contains("meeting")){
                        msg.arg1 = Constants.REQUEST_HOTEL_SERVICE_MEETING_ROOM;
                        msg.arg2 = Constants.SERVICE_ID_MEETING_ROOM;
                    }
                    else if(grammar.getText().contains("Wi-Fi")
                            || grammar.getText().contains("Internet")
                            || grammar.getText().contains("internet")
                            || grammar.getText().contains("network")
                            || grammar.getText().contains("Network")){
                        msg.arg1 = Constants.REQUEST_HOTEL_SERVICE_WIFI;
                        msg.arg2 = Constants.SERVICE_ID_WIFI;
                    }
                    else if(grammar.getText().contains("Smartphone")
                            || grammar.getText().contains("smartphone")
                            || grammar.getText().contains("smartphones")
                            || grammar.getText().contains("My local phone")
                            || grammar.getText().contains("my local phone")){
                        if(Hotel.getId() == Constants.HOTEL_ID_LA_VILLA_DES_TERNES
                                || Hotel.getId() == Constants.HOTEL_ID_MAGDA_CHAMPS_ELYSEES){
                            msg.arg1 = Constants.REQUEST_HOTEL_SERVICE_MYLOCALPHONE;
                            msg.arg2 = Constants.SERVICE_ID_MYLOCALPHONE;
                        }
                        else{
                            // Request error and hotel services
                        }
                    }
                    else if(grammar.getText().contains("spa")
                            || grammar.getText().contains("Spa")
                            || grammar.getText().contains("Sauna")
                            || grammar.getText().contains("sauna")
                            || grammar.getText().contains("Hammam")
                            || grammar.getText().contains("hammam")){
                        if(Hotel.getId() == Constants.HOTEL_ID_LA_VILLA_DES_TERNES
                                || Hotel.getId() == Constants.HOTEL_ID_LES_JARDINS_DE_LA_VILLA){
                            msg.arg1 = Constants.REQUEST_HOTEL_SERVICE_SPA;
                            msg.arg2 = Constants.SERVICE_ID_SPA;
                        }
                        else {
                            // Request error and hotel services
                        }
                    }
                    else if(grammar.getText().contains("Concierge")
                            || grammar.getText().contains("concierge")){
                        if(Hotel.getId() == Constants.HOTEL_ID_LES_JARDINS_DE_LA_VILLA
                                || Hotel.getId() == Constants.HOTEL_ID_MAGDA_CHAMPS_ELYSEES){
                            msg.arg1 = Constants.REQUEST_HOTEL_SERVICE_CONCIERGE;
                            msg.arg2 = Constants.SERVICE_ID_CONCIERGE_EXTRA_AMENITIES;
                        }
                        else if(Hotel.getId() == Constants.HOTEL_ID_ACACIAS_ETOILE
                                || Hotel.getId() == Constants.HOTEL_ID_LA_VILLA_DES_TERNES){
                            msg.arg1 = Constants.REQUEST_HOTEL_SERVICE_CONCIERGE;
                            msg.arg2 = Constants.SERVICE_ID_CONCIERGE;
                        }
                        else {
                            // Request Hotel services
                        }
                    }
                    else if(grammar.getText().contains("extra")
                            || grammar.getText().contains("Extra")){
                        if(Hotel.getId() == Constants.HOTEL_ID_LES_JARDINS_DE_LA_VILLA
                                || Hotel.getId() == Constants.HOTEL_ID_MAGDA_CHAMPS_ELYSEES){
                            msg.arg1 = Constants.REQUEST_HOTEL_SERVICE_EXTRA_AMENITIES;
                            msg.arg2 = Constants.SERVICE_ID_CONCIERGE_EXTRA_AMENITIES;

                        }
                        else if(Hotel.getId() == Constants.HOTEL_ID_ACACIAS_ETOILE
                                || Hotel.getId() == Constants.HOTEL_ID_LA_VILLA_DES_TERNES){
                            msg.arg1 = Constants.REQUEST_HOTEL_SERVICE_EXTRA_AMENITIES;
                            msg.arg2 = Constants.SERVICE_ID_EXTRA_AMENITIES;
                        }
                        else {
                            // Request Hotel services
                        }
                    }
                    else if(grammar.getText().contains("Weather")
                            || grammar.getText().contains("weather")
                            || grammar.getText().contains("Climate")
                            || grammar.getText().contains("climate")){
                        msg.arg1 = Constants.REQUEST_WEATHER;
                    }
                    else if(grammar.getText().contains("Station")
                            || grammar.getText().contains("station")
                            || grammar.getText().contains("stations")
                            || grammar.getText().contains("Stations")
                            || grammar.getText().contains("Stop")
                            || grammar.getText().contains("stop")
                            || grammar.getText().contains("stops")
                            || grammar.getText().contains("Stops")){
                        if(grammar.getText().contains("Bus")
                                || grammar.getText().contains("bus")
                                || grammar.getText().contains("Metro")
                                || grammar.getText().contains("metro")
                                || grammar.getText().contains("Train")
                                || grammar.getText().contains("train")
                                || grammar.getText().contains("Taxi")
                                || grammar.getText().contains("taxi")
                                || grammar.getText().contains("Transportation")
                                || grammar.getText().contains("Transportations")
                                || grammar.getText().contains("transportation")
                                || grammar.getText().contains("transportations")){
                            msg.arg1 = Constants.REQUEST_GET_AROUND_IN_PARIS;
                        }
                        else{
                            // Request Error
                        }
                    }
                    else if(grammar.getText().contains("Transportation")
                            || grammar.getText().contains("Transportations")
                            || grammar.getText().contains("transportation")
                            || grammar.getText().contains("transportations")){
                        msg.arg1 = Constants.REQUEST_GET_AROUND_IN_PARIS;
                    }
                    else if(grammar.getText().contains("Restaurant")
                            || grammar.getText().contains("restaurant")
                            || grammar.getText().contains("Restaurants")
                            || grammar.getText().contains("restaurants")
                            || grammar.getText().contains("Bakery")
                            || grammar.getText().contains("bakery")
                            || grammar.getText().contains("Bakeries")
                            || grammar.getText().contains("bakeries")
                            || grammar.getText().contains("Lunch")
                            || grammar.getText().contains("lunch")){
                        if(grammar.getText().contains("in") || grammar.getText().contains("of")
                                || grammar.getText().contains("indoor")){
                            // Request service does not exist in the hotel
                        }
                        else {
                            msg.arg1 = Constants.REQUEST_RESTAURANT_BAR_BAKERY;
                        }
                    }
                    else if(grammar.getText().contains("Place")
                            || grammar.getText().contains("place")
                            || grammar.getText().contains("Places")
                            || grammar.getText().contains("places")
                            || grammar.getText().contains("Tourism")
                            || grammar.getText().contains("tourism")
                            || grammar.getText().contains("Museum")
                            || grammar.getText().contains("museum")
                            || grammar.getText().contains("Monument")
                            || grammar.getText().contains("monument")){
                        if(grammar.getText().contains("out") || grammar.getText().contains("near")
                                || grammar.getText().contains("nearby")
                                || grammar.getText().contains("around")){
                            msg.arg1 = Constants.REQUEST_GET_AROUND_IN_PARIS;
                        }
                        else {
                           // Request error
                        }
                    }
                    else if(grammar.getText().contains("What is your job")
                            || grammar.getText().contains("What do you do")
                            || grammar.getText().contains("What can you do")
                            || grammar.getText().contains("How are you usefull")
                            || grammar.getText().contains("Are you usefull")) {
                        msg.arg1 = Constants.REQUEST_TALK_TO_ME;
                    }
                    else {
                        // Request error
                    }
                }
                else if(grammar.getText().contains("service") || grammar.getText().contains("Service")
                        || grammar.getText().contains("services")
                        || grammar.getText().contains("Services")
                        || grammar.getText().contains("Offer")
                        || grammar.getText().contains("Offers")
                        || grammar.getText().contains("offer")
                        || grammar.getText().contains("offers")){
                    if(grammar.getText().contains("Breakfast")
                            || grammar.getText().contains("breakfast")){
                        msg.arg1 = Constants.REQUEST_HOTEL_SERVICE_BREAKFAST;
                        msg.arg2 = Constants.SERVICE_ID_BREAKFAST;
                    }
                    else if(grammar.getText().contains("Bar") || grammar.getText().contains("bar")
                            || grammar.getText().contains("Drink") || grammar.getText().contains("drink")){
                        msg.arg1 = Constants.REQUEST_HOTEL_SERVICE_HONESTY_BAR;
                        msg.arg2 = Constants.SERVICE_ID_HONESTY_BAR;
                    }
                    else if(grammar.getText().contains("Meeting")
                            || grammar.getText().contains("meeting")){
                        msg.arg1 = Constants.REQUEST_HOTEL_SERVICE_MEETING_ROOM;
                        msg.arg2 = Constants.SERVICE_ID_MEETING_ROOM;
                    }
                    else if(grammar.getText().contains("Wi-Fi")
                            || grammar.getText().contains("Internet")
                            || grammar.getText().contains("internet")
                            || grammar.getText().contains("network")
                            || grammar.getText().contains("Network")){
                        msg.arg1 = Constants.REQUEST_HOTEL_SERVICE_WIFI;
                        msg.arg2 = Constants.SERVICE_ID_WIFI;
                    }
                    else if(grammar.getText().contains("Smartphone")
                            || grammar.getText().contains("smartphone")
                            || grammar.getText().contains("smartphones")
                            || grammar.getText().contains("My local phone")
                            || grammar.getText().contains("my local phone")){
                        if(Hotel.getId() == Constants.HOTEL_ID_LA_VILLA_DES_TERNES
                                || Hotel.getId() == Constants.HOTEL_ID_MAGDA_CHAMPS_ELYSEES){
                            msg.arg1 = Constants.REQUEST_HOTEL_SERVICE_MYLOCALPHONE;
                            msg.arg2 = Constants.SERVICE_ID_MYLOCALPHONE;
                        }
                        else{
                            // Request Hotel services
                        }
                    }
                    else if(grammar.getText().contains("spa")
                            || grammar.getText().contains("Spa")
                            || grammar.getText().contains("Sauna")
                            || grammar.getText().contains("sauna")
                            || grammar.getText().contains("Hammam")
                            || grammar.getText().contains("hammam")){
                        if(Hotel.getId() == Constants.HOTEL_ID_LA_VILLA_DES_TERNES
                                || Hotel.getId() == Constants.HOTEL_ID_LES_JARDINS_DE_LA_VILLA){
                            msg.arg1 = Constants.REQUEST_HOTEL_SERVICE_SPA;
                            msg.arg2 = Constants.SERVICE_ID_SPA;
                        }
                        else {
                            // Request Hotel services
                        }
                    }
                    else if(grammar.getText().contains("Concierge")
                            || grammar.getText().contains("concierge")){
                        if(Hotel.getId() == Constants.HOTEL_ID_LES_JARDINS_DE_LA_VILLA
                                || Hotel.getId() == Constants.HOTEL_ID_MAGDA_CHAMPS_ELYSEES){
                            msg.arg1 = Constants.REQUEST_HOTEL_SERVICE_CONCIERGE;
                            msg.arg2 = Constants.SERVICE_ID_CONCIERGE_EXTRA_AMENITIES;
                        }
                        else if(Hotel.getId() == Constants.HOTEL_ID_ACACIAS_ETOILE
                                || Hotel.getId() == Constants.HOTEL_ID_LA_VILLA_DES_TERNES){
                            msg.arg1 = Constants.REQUEST_HOTEL_SERVICE_CONCIERGE;
                            msg.arg2 = Constants.SERVICE_ID_CONCIERGE;
                        }
                        else {
                            // Request Hotel services
                        }
                    }
                    else if(grammar.getText().contains("extra")
                            || grammar.getText().contains("Extra")){
                        if(Hotel.getId() == Constants.HOTEL_ID_LES_JARDINS_DE_LA_VILLA
                                || Hotel.getId() == Constants.HOTEL_ID_MAGDA_CHAMPS_ELYSEES){
                            msg.arg1 = Constants.REQUEST_HOTEL_SERVICE_EXTRA_AMENITIES;
                            msg.arg2 = Constants.SERVICE_ID_CONCIERGE_EXTRA_AMENITIES;

                        }
                        else if(Hotel.getId() == Constants.HOTEL_ID_ACACIAS_ETOILE
                                || Hotel.getId() == Constants.HOTEL_ID_LA_VILLA_DES_TERNES){
                            msg.arg1 = Constants.REQUEST_HOTEL_SERVICE_EXTRA_AMENITIES;
                            msg.arg2 = Constants.SERVICE_ID_EXTRA_AMENITIES;
                        }
                        else {
                            // Request Hotel services
                        }
                    }
                    else {
                        // Request error and Sanbot services
                    }
                }
                else if(grammar.getText().contains("Paris") || grammar.getText().contains("paris")
                        || grammar.getText().contains("city")
                        || grammar.getText().contains("town")) {
                    if(grammar.getText().contains("find") || grammar.getText().contains("get")
                            || grammar.getText().contains("location")){
                        if(grammar.getText().contains("transportation")
                                || grammar.getText().contains("transportations")){

                        }
                    }
                    else if(grammar.getText().contains("How") || grammar.getText().contains("how")){

                    }
                    else if(grammar.getText().contains("What") || grammar.getText().contains("what")){

                    }
                    if(grammar.getText().contains("Place")
                            || grammar.getText().contains("place")
                            || grammar.getText().contains("Places")
                            || grammar.getText().contains("places")
                            || grammar.getText().contains("Tourism")
                            || grammar.getText().contains("tourism")
                            || grammar.getText().contains("Museum")
                            || grammar.getText().contains("museum")
                            || grammar.getText().contains("Monument")
                            || grammar.getText().contains("monument")
                            || grammar.getText().contains("Picture")
                            || grammar.getText().contains("Pictures")
                            || grammar.getText().contains("picture")
                            || grammar.getText().contains("pictures")){
                        if(grammar.getText().contains("Where")
                                || grammar.getText().contains("where")){
                            if(grammar.getText().contains("Transportation")
                                    || grammar.getText().contains("transportation")){

                            }
                        }
                    }
                }
                */
                else if(grammar.getText().contains("How are you")
                        || grammar.getText().contains("how are you")){
                    msg.arg1 = Constants.REQUEST_SALUTATIONS;
                }
                else if(grammar.getText().contains("Hello")
                        || grammar.getText().contains("hello")
                        || grammar.getText().contains("Hi")){
                    msg.arg1 = Constants.REQUEST_HELLO;
                }
                else if (grammar.getText().contains("I am fine")
                        || grammar.getText().contains("i am fine")
                        || grammar.getText().contains("I am doing well")
                        || grammar.getText().contains("i am doing well")
                        || grammar.getText().contains("I'm fine")
                        || grammar.getText().contains("i'm fine")
                        || grammar.getText().contains("I'm doing well")
                        || grammar.getText().contains("i'm doing well")){
                    msg.arg1 = Constants.REQUEST_HUMAN_FEELING;
                }
                else if ((grammar.getText().contains("I am fine") && grammar.getText().contains("how about you"))
                        || (grammar.getText().contains("I am fine") && grammar.getText().contains("how are you"))
                        || (grammar.getText().contains("I am fine") && grammar.getText().contains("and you"))
                        || (grammar.getText().contains("I am doing well") && grammar.getText().contains("how about you"))
                        || (grammar.getText().contains("I am doing well") && grammar.getText().contains("how are you"))
                        || (grammar.getText().contains("I am doing well") && grammar.getText().contains("and you"))
                        || (grammar.getText().contains("I'm fine") && grammar.getText().contains("how about you"))
                        || (grammar.getText().contains("I'm fine") && grammar.getText().contains("how are you"))
                        || (grammar.getText().contains("I'm fine") && grammar.getText().contains("and you"))
                        || (grammar.getText().contains("I'm doing well") && grammar.getText().contains("how about you"))
                        || (grammar.getText().contains("I'm doing well") && grammar.getText().contains("how are you"))
                        || (grammar.getText().contains("I'm doing well") && grammar.getText().contains("and you"))){
                    msg.arg1 = Constants.REQUEST_ROBOT_FEELING;
                }
                else if (grammar.getText().contains("I am very sad")
                        || grammar.getText().contains("i am very sad")
                        || grammar.getText().contains("I am sad")
                        || grammar.getText().contains("i am sad")
                        || grammar.getText().contains("I'm very sad")
                        || grammar.getText().contains("i'm very sad")
                        || grammar.getText().contains("I'm sad")
                        || grammar.getText().contains("i'm sad")){
                    msg.arg1 = Constants.REQUEST_HUMAN_SAD_FEELING;
                }
                else if (grammar.getText().contains("I am very sick")
                        || grammar.getText().contains("i am very sick")
                        || grammar.getText().contains("I am ill")
                        || grammar.getText().contains("i am ill")
                        || grammar.getText().contains("I fell bad")
                        || grammar.getText().contains("i feel bad")
                        || grammar.getText().contains("I feel very bad")
                        || grammar.getText().contains("i fell very bad")
                        || grammar.getText().contains("I'm very sick")
                        || grammar.getText().contains("i'm very sick")
                        || grammar.getText().contains("I'm ill")
                        || grammar.getText().contains("i'm ill")){
                    msg.arg1 = Constants.REQUEST_HUMAN_SICK_FEELING;
                }
                else if (grammar.getText().contains("Nice to meet you")
                        || grammar.getText().contains("nice to meet you")){
                    msg.arg1 = Constants.REQUEST_MEETING;
                }
                else if (grammar.getText().contains("What is your name")
                        || grammar.getText().contains("what is your name")
                        || grammar.getText().contains("Who are you")
                        || grammar.getText().contains("who are you")
                        || grammar.getText().contains("What is your nickname")
                        || grammar.getText().contains("what is your nickname")){
                    msg.arg1 = Constants.REQUEST_NAME;
                }
                else if (grammar.getText().contains("What are you")
                        || grammar.getText().contains("what are you")
                        || grammar.getText().contains("What are you used for")
                        || grammar.getText().contains("what are you used for")
                        || grammar.getText().contains("What are you for")
                        || grammar.getText().contains("what are you for")
                        || grammar.getText().contains("What do you do")
                        || grammar.getText().contains("what do you do")
                        || grammar.getText().contains("What is your job")
                        || grammar.getText().contains("what is your job")){
                    msg.arg1 = Constants.REQUEST_JOB;
                }
                else if (grammar.getText().contains("Where are you from")
                        || grammar.getText().contains("where are you from")){
                    msg.arg1 = Constants.REQUEST_ORIGIN;
                }
                else if(grammar.getText().contains("How old are you")
                        || grammar.getText().contains("how old are you")){
                    msg.arg1 = Constants.REQUEST_AGE;
                }
                else if (grammar.getText().contains("How tall are you")
                        || grammar.getText().contains("how tall are you")){
                    msg.arg1 = Constants.REQUEST_SIZE;
                }
                else if (grammar.getText().contains("What are you made of")
                        || grammar.getText().contains("what are you made of")){
                    msg.arg1 = Constants.REQUEST_NATURE;
                }
                else if (grammar.getText().contains("What is your tablet for")
                        || grammar.getText().contains("what is your tablet for")){
                    msg.arg1 = Constants.REQUEST_TABLET_USAGE;
                }
                else if (grammar.getText().contains("Are you boy or a girl")
                        || grammar.getText().contains("are you a boy or a girl")
                        || grammar.getText().contains("Are you male or female")
                        || grammar.getText().contains("are you male or female")
                        || grammar.getText().contains("What is your sex")
                        || grammar.getText().contains("what is your sex")){
                    msg.arg1 = Constants.REQUEST_SEX;
                }
                else if (grammar.getText().contains("Do you have boyfriend")
                        || grammar.getText().contains("do you have boyfriend")
                        || grammar.getText().contains("Have you a boyfriend")
                        || grammar.getText().contains("have you a boyfriend")
                        || grammar.getText().contains("Are you got married")
                        || grammar.getText().contains("are you got married")){
                    msg.arg1 = Constants.REQUEST_PARTNER;
                }
                else if (grammar.getText().contains("When is your birthday")
                        || grammar.getText().contains("when is your birthday")){
                    msg.arg1 = Constants.REQUEST_BIRTHDAY;
                }
                else if (grammar.getText().contains("How much do you weigh")
                        || grammar.getText().contains("how much do you weigh")){
                    msg.arg1 = Constants.REQUEST_WEIGH;
                }
                else if (grammar.getText().contains("Who is your mother")
                        || grammar.getText().contains("who is your mother")){
                    msg.arg1 = Constants.REQUEST_MOTHER;
                }
                else if (grammar.getText().contains("Who is your dad")
                        || grammar.getText().contains("who is your mother")){
                    msg.arg1 = Constants.REQUEST_FATHER;
                }
                else if (grammar.getText().contains("Where were you made")
                        || grammar.getText().contains("where were you made")
                        || grammar.getText().contains("Where are you made")
                        || grammar.getText().contains("where are you made")){
                    msg.arg1 = Constants.REQUEST_BULDING_ORIGIN;
                }
                else if (grammar.getText().contains("Who made you")
                        || grammar.getText().contains("who made you")
                        || grammar.getText().contains("Who built you")
                        || grammar.getText().contains("who built you")){
                    msg.arg1 = Constants.REQUEST_BUILDER;
                }
                else if (grammar.getText().contains("Who is your master")
                        || grammar.getText().contains("who is your master")
                        || grammar.getText().contains("Who is your boss")
                        || grammar.getText().contains("who is your boss")){
                    msg.arg1 = Constants.REQUEST_MASTER;
                }
                else if(grammar.getText().contains("music")){
                    if(grammar.getText().contains("Play") || grammar.getText().contains("play")
                        || grammar.getText().contains("Hear") || grammar.getText().contains("hear")) {
                        msg.arg1 = Constants.REQUEST_PLAY_MUSIC;
                    }
                    else if(grammar.getText().contains("Stop") || grammar.getText().contains("stop")
                            || (grammar.getText().contains("turn") && grammar.getText().contains("off"))
                            || (grammar.getText().contains("Turn") && grammar.getText().contains("off"))){
                        msg.arg1 = Constants.REQUEST_STOP_MUSIC;
                    }
                }
                else {
                    msg.arg1 = Constants.REQUEST_ERROR;
                }
                try {
                    SanbotApp.getmService().send(msg);
                }
                catch(RemoteException e) {
                    e.printStackTrace();
                }
                Log.d(TAG, "onRecognizeResult: " + grammar.getText());
                return true;
            }

            @Override
            public void onRecognizeVolume(int i) {
                Log.d(TAG,"onRecognizeVolume: " + i);
            }
        });

        Sanbot.getHardWareManager().setOnHareWareListener(new TouchSensorListener() {
            @Override
            public void onTouch(int i) {
                double j = Math.random();
                if (i == 11 || i == 12 || i == 13){
                    if(SanbotIntentService.getMediaPlayer() != null){
                        SanbotIntentService.stopMusic(getContext());
                    }
                    if(j <= 0.3){
                        Sanbot.say("How can i be funny for you ?", 50);
                    }
                    else if (j <= 0.6){
                        Sanbot.say("Would you want something ?", 50);
                    }
                    else {
                        Sanbot.say("Would you tell me something ?", 50);
                    }
                }
            }
        });

        Sanbot.getSpeechManager().setOnSpeechListener(new WakenListener() {
            @Override
            public void onWakeUp() {
                Sanbot.getSystemManager().showEmotion(EmotionsType.SURPRISE);
                //Sanbot.say("Sorry, i have just waken up ! How can i help you ?", 50);
            }

            @Override
            public void onSleep() {
                Sanbot.getSystemManager().showEmotion(EmotionsType.SLEEP);
            }
        });
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        //msg = mServiceHandler.obtainMessage();
        //msg.arg1 = startId;
        bindService(SanbotApp.getServiceLauncherIntent(), mConnection, Context.BIND_AUTO_CREATE);
        return START_NOT_STICKY;
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
}
