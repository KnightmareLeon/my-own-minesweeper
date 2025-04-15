package main.menu.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.frames.MainFrame;
import main.menu.MenuButton;
import main.sound.Sound;

public class NewGameButton extends MenuButton{
    public NewGameButton(MainFrame mFrame, Sound sound){
        super(mFrame, sound);
        this.setText("New Game");
        this.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                goToPanel(MainFrame.START_NEW_GAME_MENU);
            }
            
        });
    }
}
