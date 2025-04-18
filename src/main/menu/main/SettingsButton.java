package main.menu.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.frames.MainFrame;
import main.menu.MenuButton;
import main.sound.Sound;

public class SettingsButton extends MenuButton{
    public SettingsButton(MainFrame mFrame, Sound sound){
        super(mFrame, sound);
        this.setText("Settings");
        this.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                goToPanel(MainFrame.SETTINGS);
            }
        });
    }
    
}
