package main.menu.settings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import main.sound.Sound;

public class VolumeDownButton extends SettingsButton{
    public VolumeDownButton(JLabel volumeLabel, Sound sound){
        super(sound);
        this.setText("DOWN");
        this.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int volume = ((int) (sound.getVolume() * 10)) - 1;
                System.out.println(volume);
                if(volume > 0){
                    sound.setVolume( ((float)volume) / 10);
                    volumeLabel.setText(String.format("Volume: %d", volume));
                }
                playSound();
            }
            
        });
    }
}
