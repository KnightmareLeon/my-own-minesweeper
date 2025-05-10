package main.menu.settings;

import java.awt.Color;

import javax.swing.BorderFactory;

import main.defaults.DefaultButton;
import main.sound.Sound;

public class SettingsButton extends DefaultButton{

    public SettingsButton(Sound sound) {
        super(sound);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    }

}
