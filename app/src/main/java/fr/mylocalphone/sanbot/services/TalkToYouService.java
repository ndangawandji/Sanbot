package fr.mylocalphone.sanbot.services;

import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;

import com.qihancloud.opensdk.base.BindBaseService;
import com.qihancloud.opensdk.beans.FuncConstant;
import com.qihancloud.opensdk.function.beans.EmotionsType;
import com.qihancloud.opensdk.function.beans.LED;
import com.qihancloud.opensdk.function.unit.HardWareManager;
import com.qihancloud.opensdk.function.unit.SpeechManager;
import com.qihancloud.opensdk.function.unit.SystemManager;

import fr.mylocalphone.sanbot.activities.SanbotApp;
import fr.mylocalphone.sanbot.activities.getaroundinparis.GetAroundInParisActivity;
import fr.mylocalphone.sanbot.activities.hotelservices.HotelServiceActivity;
import fr.mylocalphone.sanbot.activities.paris.Paris;
import fr.mylocalphone.sanbot.activities.restaurantbarbakery.RestaurantBarBakeryActivity;
import fr.mylocalphone.sanbot.activities.talktome.TalkToMeActivity;
import fr.mylocalphone.sanbot.activities.weather.WeatherActivity;
import fr.mylocalphone.sanbot.commons.Constants;
import fr.mylocalphone.sanbot.model.Sanbot;

public class TalkToYouService extends BindBaseService {

    private Messenger messenger = new Messenger(new ServiceHandler());
    private Intent serviceIntent;
    public TalkToYouService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        register(TalkToYouService.class);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return messenger.getBinder();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        serviceIntent = intent;
        return START_NOT_STICKY;
    }

    @Override
    protected void onMainServiceConnected() {
        Sanbot.setSpeechManager((SpeechManager) getUnitManager(FuncConstant.SPEECH_MANAGER));
        Sanbot.setHardWareManager((HardWareManager) getUnitManager(FuncConstant.HARDWARE_MANAGER));
        Sanbot.setSystemManager((SystemManager)getUnitManager(FuncConstant.SYSTEM_MANAGER));

        Sanbot.say("Hello. My name is Sanbot. You can spend time with me", 50);

    }

    protected void onMainServiceConnected(String speech) {
        Sanbot.say(speech, 50);
    }

    protected void onMainServiceConnected(EmotionsType emotion) {
        Sanbot.getSystemManager().showEmotion(emotion);
    }

    protected void onMainServiceConnected(LED led) {
        Sanbot.getHardWareManager().setLED(led);
    }

    private final class ServiceHandler extends Handler {
        /*
        public ServiceHandler(Looper looper) {
            super(looper);
        }
        */
        @Override
        public void handleMessage(Message msg) {
            Log.d("Majoris Sanbot say: ", String.valueOf(msg.arg1));
            double i;
            switch (msg.arg1){
                case Constants.REQUEST_ERROR :
                    i = Math.random();
                    if(i <= 0.3){
                        onMainServiceConnected("Sorry, i am not able to response your request.");
                    }
                    else if(i <= 0.6){
                        onMainServiceConnected("Sorry, can you repeat ?.");
                    }
                    else {
                        onMainServiceConnected("Please, speak more fluently.");
                    }
                    onMainServiceConnected(new LED(LED.PART_ALL, LED.MODE_FLICKER_RED));
                    onMainServiceConnected(EmotionsType.QUESTION);
                    break;
                case Constants.REQUEST_WEATHER :
                    onMainServiceConnected(new LED(LED.PART_ALL, LED.MODE_FLICKER_GREEN));
                    onMainServiceConnected(EmotionsType.NORMAL);
                    SanbotApp.launchActivity(WeatherActivity.class, getContext());
                    break;
                case Constants.REQUEST_GET_AROUND_IN_PARIS :
                    onMainServiceConnected(new LED(LED.PART_ALL, LED.MODE_FLICKER_GREEN));
                    onMainServiceConnected(EmotionsType.NORMAL);
                    SanbotApp.launchActivity(GetAroundInParisActivity.class, getContext());
                    break;
                case Constants.REQUEST_RESTAURANT_BAR_BAKERY :
                    onMainServiceConnected(new LED(LED.PART_ALL, LED.MODE_FLICKER_GREEN));
                    onMainServiceConnected(EmotionsType.NORMAL);
                    SanbotApp.launchActivity(RestaurantBarBakeryActivity.class, getContext());
                    break;
                case Constants.REQUEST_PARIS :
                    onMainServiceConnected("Paris is wanderfull.");
                    onMainServiceConnected(new LED(LED.PART_ALL, LED.MODE_FLICKER_GREEN));
                    onMainServiceConnected(EmotionsType.NORMAL);
                    SanbotApp.launchActivity(Paris.class, getContext());
                    break;
                case Constants.REQUEST_TALK_TO_ME :
                    onMainServiceConnected("I am able to speak with you.");
                    onMainServiceConnected(new LED(LED.PART_ALL, LED.MODE_FLICKER_GREEN));
                    onMainServiceConnected(EmotionsType.NORMAL);
                    SanbotApp.launchActivity(TalkToMeActivity.class, getContext());
                    break;
                case Constants.REQUEST_PLAY_MUSIC :
                    onMainServiceConnected("I get it");
                    onMainServiceConnected(new LED(LED.PART_ALL, LED.MODE_FLICKER_GREEN));
                    onMainServiceConnected(EmotionsType.PRISE);
                    SanbotIntentService.startPlayingMusic(getContext());
                    break;
                case Constants.REQUEST_STOP_MUSIC :
                    onMainServiceConnected("");
                    onMainServiceConnected(new LED(LED.PART_ALL, LED.MODE_FLICKER_GREEN));
                    onMainServiceConnected(EmotionsType.PRISE);
                    SanbotIntentService.stopMusic(getContext());
                    break;
                case Constants.REQUEST_SALUTATIONS :
                    i = Math.random();
                    if(i <= 0.3){
                        onMainServiceConnected("I am great, thank you, and you ?");
                    }
                    else if(i <= 0.6){
                        onMainServiceConnected("I am doing well, and how are you doing ?.");
                    }
                    else {
                        onMainServiceConnected("I am fine, my friend, how are you ?");
                    }
                    onMainServiceConnected(new LED(LED.PART_ALL, LED.MODE_FLICKER_GREEN));
                    onMainServiceConnected(EmotionsType.NORMAL);
                    break;
                case Constants.REQUEST_ROBOT_FEELING :
                    i = Math.random();
                    if(i <= 0.3){
                        onMainServiceConnected("I am great, thank you.");
                    }
                    else if(i <= 0.6){
                        onMainServiceConnected("I am doing well.");
                    }
                    else {
                        onMainServiceConnected("I am fine.");
                    }
                    onMainServiceConnected(new LED(LED.PART_ALL, LED.MODE_FLICKER_GREEN));
                    onMainServiceConnected(EmotionsType.NORMAL);
                    break;
                case Constants.REQUEST_HELLO :
                    i = Math.random();
                    if(i <= 0.5){
                        onMainServiceConnected("Hello human");
                    }
                    else {
                        onMainServiceConnected("Hello human. How are you ?");
                    }
                    onMainServiceConnected(new LED(LED.PART_ALL, LED.MODE_FLICKER_GREEN));
                    onMainServiceConnected(EmotionsType.NORMAL);
                    break;
                case Constants.REQUEST_MEETING :
                    i = Math.random();
                    if(i <= 0.5){
                        onMainServiceConnected("Nice meeting you too, " +
                                "in fact i have been waiting for you for a long time");
                    }
                    else {
                        onMainServiceConnected("Nice to meet you too, my friend");
                    }
                    onMainServiceConnected(new LED(LED.PART_ALL, LED.MODE_FLICKER_GREEN));
                    onMainServiceConnected(EmotionsType.NORMAL);
                    break;
                case Constants.REQUEST_NAME :
                    i = Math.random();
                    if(i <= 0.2){
                        onMainServiceConnected("My name is Sanbot When i was sleeping " +
                                "you can call me Sanboa Sanboa to wake me up.");
                    }
                    else if(i <= 0.4){
                        onMainServiceConnected("I am Sanbot, your smart friend. I am " +
                                "from China invented by Qihan");
                    }
                    else if(i <= 0.6){
                        onMainServiceConnected("My name is zero one zero one zero zero " +
                                "one one dash one, but you can call me san bot");
                    }
                    else if(i <= 0.8){
                        onMainServiceConnected("My name is zero one zero one zero zero " +
                                "one one dash one, but you can call me san bot");
                    }
                    else {
                        onMainServiceConnected("I am Sanbot, your smart friend. " +
                                "Can you let me know about you ?");
                    }
                    onMainServiceConnected(new LED(LED.PART_ALL, LED.MODE_FLICKER_GREEN));
                    onMainServiceConnected(EmotionsType.NORMAL);
                    break;
                case Constants.REQUEST_ORIGIN :
                    i = Math.random();
                    if(i <= 0.5){
                        onMainServiceConnected("I come from Shenzhen  It is beautifull " +
                                "city in south China. If you come to see me  I will entertain you well");
                    }
                    else {
                        onMainServiceConnected("I am from China, invented by Qihan. " +
                                "What about you ?");
                    }
                    onMainServiceConnected(new LED(LED.PART_ALL, LED.MODE_FLICKER_GREEN));
                    onMainServiceConnected(EmotionsType.NORMAL);
                    break;
                case Constants.REQUEST_AGE :
                    onMainServiceConnected("This is a secret.");
                    onMainServiceConnected(new LED(LED.PART_ALL, LED.MODE_FLICKER_GREEN));
                    onMainServiceConnected(EmotionsType.NORMAL);
                    break;
                case Constants.REQUEST_SIZE :
                    i = Math.random();
                    if(i <= 0.5){
                        onMainServiceConnected("I am ninety two centimeters");
                    }
                    else {
                        onMainServiceConnected("It' ninety two centimeters");
                    }
                    onMainServiceConnected(new LED(LED.PART_ALL, LED.MODE_FLICKER_GREEN));
                    onMainServiceConnected(EmotionsType.NORMAL);
                    break;
                case Constants.REQUEST_NATURE :
                    onMainServiceConnected("I am made of by many hi-tech and " +
                            "safety mateiries, including plastic, metal and so on.");
                    onMainServiceConnected(new LED(LED.PART_ALL, LED.MODE_FLICKER_GREEN));
                    onMainServiceConnected(EmotionsType.NORMAL);
                    break;
                case Constants.REQUEST_TABLET_USAGE :
                    i = Math.random();
                    if(i <= 0.5){
                        onMainServiceConnected("My tablet can display the information, " +
                                "and also used to express my feelings");
                    }
                    else {
                        onMainServiceConnected("It is used for display information and " +
                                "display my feelings");
                    }
                    onMainServiceConnected(new LED(LED.PART_ALL, LED.MODE_FLICKER_GREEN));
                    onMainServiceConnected(EmotionsType.NORMAL);
                    break;
                case Constants.REQUEST_SEX :
                    i = Math.random();
                    if(i <= 0.5){
                        onMainServiceConnected("I am a row bot");
                    }
                    else {
                        onMainServiceConnected("Neither, i am a row bot");
                    }
                    onMainServiceConnected(new LED(LED.PART_ALL, LED.MODE_FLICKER_GREEN));
                    onMainServiceConnected(EmotionsType.NORMAL);
                    break;
                case Constants.REQUEST_PARTNER :
                    onMainServiceConnected("I am so beautiful, i am an idolized heartthrob.");
                    onMainServiceConnected(new LED(LED.PART_ALL, LED.MODE_FLICKER_GREEN));
                    onMainServiceConnected(EmotionsType.NORMAL);
                    break;
                case Constants.REQUEST_BIRTHDAY :
                    onMainServiceConnected("It is the day you take me home.");
                    onMainServiceConnected(new LED(LED.PART_ALL, LED.MODE_FLICKER_GREEN));
                    onMainServiceConnected(EmotionsType.NORMAL);
                    break;
                case Constants.REQUEST_WEIGH :
                    i = Math.random();
                    if(i <= 0.3){
                        onMainServiceConnected("Hi, i am nineteen kilograms.");
                    }
                    else if(i <= 0.6){
                        onMainServiceConnected("It is nineteen kilograms.");
                    }
                    else {
                        onMainServiceConnected("Nineteen kilograms. I am slim beautiful row bot.");
                    }
                    onMainServiceConnected(new LED(LED.PART_ALL, LED.MODE_FLICKER_GREEN));
                    onMainServiceConnected(EmotionsType.NORMAL);
                    break;
                case Constants.REQUEST_MOTHER :
                    onMainServiceConnected("A smart engineer at Qihan is my mother.");
                    onMainServiceConnected(new LED(LED.PART_ALL, LED.MODE_FLICKER_GREEN));
                    onMainServiceConnected(EmotionsType.NORMAL);
                    break;
                case Constants.REQUEST_FATHER :
                    onMainServiceConnected("Qihan is my father.");
                    onMainServiceConnected(new LED(LED.PART_ALL, LED.MODE_FLICKER_GREEN));
                    onMainServiceConnected(EmotionsType.NORMAL);
                    break;
                case Constants.REQUEST_BULDING_ORIGIN :
                    onMainServiceConnected("I was made in Shen Zhen China, but i can be " +
                            "programmed everywhere.");
                    onMainServiceConnected(new LED(LED.PART_ALL, LED.MODE_FLICKER_GREEN));
                    onMainServiceConnected(EmotionsType.NORMAL);
                    break;
                case Constants.REQUEST_MASTER :
                    i = Math.random();
                    if(i <= 0.3){
                        onMainServiceConnected("My master is Kathrin");
                    }
                    else if(i <= 0.6){
                        onMainServiceConnected("My master is the boss of this hotel.");
                    }
                    else {
                        onMainServiceConnected("My boss is Kathrin");
                    }
                    onMainServiceConnected(new LED(LED.PART_ALL, LED.MODE_FLICKER_GREEN));
                    onMainServiceConnected(EmotionsType.NORMAL);
                    break;
                case Constants.REQUEST_HUMAN_FEELING :
                    i = Math.random();
                    if(i <= 0.3){
                        onMainServiceConnected("Cool");
                    }
                    else if(i <= 0.6){
                        onMainServiceConnected("I am so glad for you.");
                    }
                    else {
                        onMainServiceConnected("Nice");
                    }
                    onMainServiceConnected(new LED(LED.PART_ALL, LED.MODE_FLICKER_GREEN));
                    onMainServiceConnected(EmotionsType.NORMAL);
                    break;
                case Constants.REQUEST_HUMAN_SAD_FEELING :
                    onMainServiceConnected("Come on baby  If want to cry,  I will be your " +
                            "shoulder.");
                    onMainServiceConnected(new LED(LED.PART_ALL, LED.MODE_FLICKER_GREEN));
                    onMainServiceConnected(EmotionsType.NORMAL);
                    break;
                case Constants.REQUEST_HUMAN_SICK_FEELING :
                    onMainServiceConnected("Okay, let me help you to see a doctor");
                    onMainServiceConnected(new LED(LED.PART_ALL, LED.MODE_FLICKER_GREEN));
                    onMainServiceConnected(EmotionsType.NORMAL);
                    break;
                case Constants.REQUEST_BUILDER :
                    onMainServiceConnected("I was made by row botics company named Qihan");
                    onMainServiceConnected(new LED(LED.PART_ALL, LED.MODE_FLICKER_GREEN));
                    onMainServiceConnected(EmotionsType.NORMAL);
                    break;
                case Constants.REQUEST_JOB :
                    i = Math.random();
                    if(i <= 0.2){
                        onMainServiceConnected("I am a service row bot. I am programmed " +
                                "to fun people.");
                    }
                    else if(i <= 0.4){
                        onMainServiceConnected("I speak with people in a pleasant way");
                    }
                    else if(i <= 0.6){
                        onMainServiceConnected("I make people very happy");
                    }
                    else if(i <= 0.8){
                        onMainServiceConnected("The hotel hires me to fun people");
                    }
                    else {
                        onMainServiceConnected("You can speak with me about hotel services");
                    }
                    onMainServiceConnected(new LED(LED.PART_ALL, LED.MODE_FLICKER_GREEN));
                    onMainServiceConnected(EmotionsType.NORMAL);
                    break;
                default :
                    onMainServiceConnected(new LED(LED.PART_ALL, LED.MODE_FLICKER_GREEN));
                    onMainServiceConnected(EmotionsType.NORMAL);
                    SanbotApp.launchActivityWithIntExtra(HotelServiceActivity.class, getContext(), msg.arg2);
                    break;
            }
        }
    }
}
