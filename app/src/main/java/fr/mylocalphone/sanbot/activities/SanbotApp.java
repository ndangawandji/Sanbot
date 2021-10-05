/**
 * All operations about general context of the application.
 * Operations include language configurations, starting activities and services,
 * and screen management. All activities involve this object.
 *
 * Developed by Ndanga Wandji.
 */

package fr.mylocalphone.sanbot.activities;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Messenger;
import android.view.Window;
import android.view.WindowManager;

import java.util.Locale;


public class SanbotApp {

    /**
     * Language configuration constants
     * FRENCH_LANGUAGE constant contains the french language provided
     * by the string.xml_fr-rFR resource file
     * ENGLISH_LANGUAGE consntant contains the english language(default language)
     * provided by the string.xml resource file
     * UK_COUNTRY constant contains the country code of UK
     * FRANCE_COUNTRY constant contains the country code of FRANCE.
     */
    public static final String FRENCH_LANGUAGE      = Locale.FRENCH.getLanguage();
    public static final String ENGLISH_LANGUAGE     = Locale.ENGLISH.getLanguage();
    public static final String UK_COUNTRY           = Locale.US.getCountry();
    public static final String FRANCE_COUNTRY       = Locale.FRANCE.getCountry();

    private static Intent activityLauncherIntent;
    private static Intent parentIntent;
    private static Intent serviceLauncherIntent;

    private static Messenger mService;

    private static Locale locale = new Locale(ENGLISH_LANGUAGE);
    private static Application application;

    private static Window screen;

    public SanbotApp() {}

    public SanbotApp(Application application, Window screen) {
        SanbotApp.setApplication(application);
        SanbotApp.setScreen(screen);
    }

    /**
     *
     * @param language
     * @return
     */
    public int changeLocale(String language){
        if(!language.equals(SanbotApp.getLocale().getLanguage())) {
            if(language.equals(FRENCH_LANGUAGE)) {
                SanbotApp.setLocale(new Locale(SanbotApp.FRENCH_LANGUAGE, SanbotApp.FRANCE_COUNTRY));
            }
            else {
                SanbotApp.setLocale(new Locale(SanbotApp.ENGLISH_LANGUAGE, SanbotApp.UK_COUNTRY));
            }
            SanbotApp.getApplication().getApplicationContext().getResources().getConfiguration().setLocale(SanbotApp.getLocale());
            return 1;
        }
        else {
            return 0;
        }
    }

    /**
     * Use this method when you want to start an android activity
     * @param activityClass
     * @param context
     */
    public static void launchActivity(Class activityClass, Context context) {
        SanbotApp.setActivityLauncherIntent(new Intent(context, activityClass));
        SanbotApp.getActivityLauncherIntent().setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(SanbotApp.getActivityLauncherIntent());
    }

    /**
     * Use this method when you want to start an android activity with an string extra
     * @param activityClass
     * @param context
     * @param extra
     */
    public static void launchActivityWithStringExtra(Class activityClass, Context context, String extra) {
        SanbotApp.setActivityLauncherIntent(new Intent(context, activityClass));
        SanbotApp.getActivityLauncherIntent().putExtra("extra", extra);
        context.startActivity(SanbotApp.getActivityLauncherIntent());
    }

    /**
     * Use this method when you want to start an android activity with an integer extra
     * @param activityClass
     * @param context
     * @param extra
     */
    public static void launchActivityWithIntExtra(Class activityClass, Context context, int extra) {
        SanbotApp.setActivityLauncherIntent(new Intent(context, activityClass));
        SanbotApp.getActivityLauncherIntent().putExtra("extra", extra);
        SanbotApp.getActivityLauncherIntent().setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(SanbotApp.getActivityLauncherIntent());
    }

    /**
     * Use this method when you want to get the extra from the intent used to start an activity with
     * launchActivityWithExtra() method
     * @return
     */
    public String getIntentStringExtra() {
        return SanbotApp.getActivityLauncherIntent().getStringExtra("extra");
    }

    /**
     * Use this method when you want to start an android service
     * @param serviceClass
     * @param context
     */
    public static void launchService(Class serviceClass, Context context) {
        SanbotApp.setServiceLauncherIntent(new Intent(context, serviceClass));
        context.startService(SanbotApp.getServiceLauncherIntent());
    }

    /**
     * Use this method when you want to start an android service with an extra
     * @param serviceClass
     * @param context
     * @param extra
     */
    public void launchServiceWithExtra(Class serviceClass, Context context, String extra) {
        SanbotApp.setServiceLauncherIntent(new Intent(context, serviceClass));
        SanbotApp.getServiceLauncherIntent().putExtra("extra", extra);
        context.startService(SanbotApp.getServiceLauncherIntent());
    }

    /**
     * Use this method if you want the display on the screen stay always awake.
     */
    public void keepScreenAwake() {
        SanbotApp.getScreen().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,
                WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    public static void setLocale(Locale locale) {
        SanbotApp.locale = locale;
    }

    public static Locale getLocale() {
        return SanbotApp.locale;
    }

    public static Intent getActivityLauncherIntent() {
        return activityLauncherIntent;
    }

    public static void setActivityLauncherIntent(Intent activityLauncherIntent) {
        SanbotApp.activityLauncherIntent = activityLauncherIntent;
    }

    public static Application getApplication() {
        return application;
    }

    public static void setApplication(Application application) {
        SanbotApp.application = application;
    }

    public static Intent getParentIntent() {
        return parentIntent;
    }

    public static void setParentIntent(Intent parentIntent) {
        SanbotApp.parentIntent = parentIntent;
    }

    public static Window getScreen() {
        return screen;
    }

    public static void setScreen(Window screen) {
        SanbotApp.screen = screen;
    }

    public static Intent getServiceLauncherIntent() {
        return serviceLauncherIntent;
    }

    public static void setServiceLauncherIntent(Intent serviceLauncherIntent) {
        SanbotApp.serviceLauncherIntent = serviceLauncherIntent;
    }

    public static Messenger getmService() {
        return mService;
    }

    public static void setmService(Messenger mService) {
        SanbotApp.mService = mService;
    }


}
