package com.example.demo3;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class TextToSpeech {
    Voice voice;

    public void Speak(String words) {
        voice.speak(words);
    }

    public  TextToSpeech(String words) {
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        voice =VoiceManager.getInstance().getVoice("kevin16");
        if (voice != null) {
            voice.allocate();
            voice.setRate(170);
            voice.setPitch(140);
            voice.setVolume(5);
            Speak(words);
        }
    }

}
