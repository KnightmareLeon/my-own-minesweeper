package main.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.frames.MainFrame;
import main.sound.Sound;

public class MainMenuButton extends MenuButton{
    public MainMenuButton(MainFrame mFrame, Sound sound){
        super(mFrame, sound);
        this.setText("Main Menu");
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                goToPanel(MainFrame.MAIN_MENU);
            }
        });
    }
}
