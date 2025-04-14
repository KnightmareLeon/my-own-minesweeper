package main.sound;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound {
    private final String AUDIO_FILE_PATH = "src/resources/sounds";
    private final String BUTTON_CLICK_SOUND = "/click-buttons-ui-menu-sounds-effects-button-7-203601.wav";
    private final String MINE_SOUND = "/explosion-123793.wav";

    private File buttonSound = new File(AUDIO_FILE_PATH + BUTTON_CLICK_SOUND);
    private File mineSound  = new File(AUDIO_FILE_PATH + MINE_SOUND);

    private AudioInputStream buttonAudioStream;
    private AudioInputStream mineAudioStream;

    private Clip buttonAudioClip;
    private Clip mineAudioClip;

    public Sound() {
        try {
            buttonAudioStream = AudioSystem.getAudioInputStream(buttonSound);
            mineAudioStream = AudioSystem.getAudioInputStream(mineSound);

            buttonAudioClip = AudioSystem.getClip();
            mineAudioClip = AudioSystem.getClip();
            
            buttonAudioClip.open(buttonAudioStream);
            mineAudioClip.open(mineAudioStream);
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }

    public void playButtonSound(){
        buttonAudioClip.setFramePosition(0);
        buttonAudioClip.start();
    }

    public void playMineSound(){
        mineAudioClip.setFramePosition(0);
        mineAudioClip.start();
    }

    public void setVolume(float volume){
        if (volume < 0f || volume > 1f){
            throw new IllegalArgumentException("Volume not valid: " + volume);
        }
        FloatControl buttonGainControl = (FloatControl) buttonAudioClip.getControl(FloatControl.Type.MASTER_GAIN);
        FloatControl mineGainControl = (FloatControl) mineAudioClip.getControl(FloatControl.Type.MASTER_GAIN);        
        buttonGainControl.setValue(20f * (float) Math.log10(volume));
        mineGainControl.setValue(20f * (float) Math.log10(volume));
    }

}
