package main.menu.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.frames.MainFrame;
import main.menu.MenuButton;

public class SettingsButton extends MenuButton{
    public SettingsButton(MainFrame mFrame){
        this.setText("Settings");
        this.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                mFrame.setContentPane(MainFrame.SETTINGS);
            }
        });
    }
    
}
