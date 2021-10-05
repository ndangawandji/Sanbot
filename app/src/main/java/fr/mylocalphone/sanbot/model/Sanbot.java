/**
 * Model class representing the robot Sanbot.
 * Developed by Ndanga Wandji.
 */

package fr.mylocalphone.sanbot.model;

import android.util.Log;

import com.qihancloud.opensdk.beans.OperationResult;
import com.qihancloud.opensdk.function.beans.SpeakOption;
import com.qihancloud.opensdk.function.unit.HardWareManager;
import com.qihancloud.opensdk.function.unit.MediaManager;
import com.qihancloud.opensdk.function.unit.SpeechManager;
import com.qihancloud.opensdk.function.unit.SystemManager;


public class Sanbot {

    private static HardWareManager hardWareManager;
    private static SpeechManager speechManager;
    private static SystemManager systemManager;
    private static MediaManager mediaManager;

    /**
     * Use this method when you want the robot speak
     * @param speech
     * @param speed
     * @return
     */
    public static OperationResult say(String speech, int speed) {
        SpeakOption speakOption = new SpeakOption();
        speakOption.setSpeed(speed);
        Log.d("Majoris: ", "Sanbot is ready to speak");
        return getSpeechManager().startSpeak(speech, speakOption);
    }

    /**
     * Use this method when you want the system return button disabled
     * @param activity
     * @return
     */
    public static OperationResult unableSystemReturnButton(String activity){
        return systemManager.switchFloatBar(false, activity);
    }

    public static HardWareManager getHardWareManager() {
        return hardWareManager;
    }

    public static void setHardWareManager(HardWareManager hardWareManager) {
        Sanbot.hardWareManager = hardWareManager;
    }

    public static SpeechManager getSpeechManager() {
        Log.d("Majoris: ", "Sanbot begin speaking");
        return speechManager;
    }

    public static void setSpeechManager(SpeechManager speechManager) {
        Sanbot.speechManager = speechManager;
    }

    public static SystemManager getSystemManager() {
        return Sanbot.systemManager;
    }

    public static void setSystemManager(SystemManager systemManager) {
        Sanbot.systemManager = systemManager;
    }

    public static MediaManager getMediaManager() {
        return mediaManager;
    }

    public static void setMediaManager(MediaManager mediaManager) {
        Sanbot.mediaManager = mediaManager;
    }
}
