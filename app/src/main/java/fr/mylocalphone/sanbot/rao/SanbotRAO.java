package fr.mylocalphone.sanbot.rao;

import android.util.Log;

import com.qihancloud.opensdk.beans.OperationResult;
import com.qihancloud.opensdk.function.beans.SpeakOption;
import com.qihancloud.opensdk.function.unit.SpeechManager;
import com.qihancloud.opensdk.function.unit.SystemManager;

/**
 * Created by suppo on 31/01/2018.
 */

public class SanbotRAO {

    private static SpeechManager speechManager;
    private static SystemManager systemManager;

    public OperationResult say(String speech, int speed) {

        SpeakOption speakOption = new SpeakOption();
        speakOption.setSpeed(speed);
        Log.d("Majoris: ", "Sanbot is ready to speak");
        return getSpeechManager().startSpeak(speech, speakOption);
    }
    public OperationResult unableSystemReturnButton(String activity){
        return systemManager.switchFloatBar(false, activity);
    }

    public SpeechManager getSpeechManager() {
        Log.d("Majoris: ", "Sanbot begin speaking");
        return speechManager;
    }

    public void setSpeechManager(SpeechManager speechManager) {
        SanbotRAO.speechManager = speechManager;
    }

    public SystemManager getSystemManager() {
        return SanbotRAO.systemManager;
    }

    public void setSystemManager(SystemManager systemManager) {
        SanbotRAO.systemManager = systemManager;
    }



}
