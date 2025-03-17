package main.defaults;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.KeyStroke;

public abstract class DefaultButton extends JButton{
    protected final Color DEFAULT_COLOR = new Color(209, 208, 206);
    private final Color HOVER_COLOR = DEFAULT_COLOR.darker();
    private final String AUDIO_FILE_PATH = "src/resources/sounds/click-buttons-ui-menu-sounds-effects-button-7-203601.wav";

    private File audioFile = new File(AUDIO_FILE_PATH);
    private AudioInputStream audioStream;
    private Clip audioClip;

    public DefaultButton(){
        try {
            audioStream = AudioSystem.getAudioInputStream(audioFile);
            audioClip = AudioSystem.getClip();
            audioClip.open(audioStream);
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
        this.setBackground(DEFAULT_COLOR);
        this.setFocusPainted(false);
        this.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "none");
        this.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                DefaultButton.this.setBackground(HOVER_COLOR);
            }
            @Override
            public void mouseExited(MouseEvent e){
                DefaultButton.this.setBackground(DEFAULT_COLOR);
            }
        });
    }

    protected void playSound(){
        audioClip.setFramePosition(0);
        audioClip.start();
    }
}
