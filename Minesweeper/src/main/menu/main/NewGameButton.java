package main.menu.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.MainFrame;
import main.menu.MenuButton;

public class NewGameButton extends MenuButton{
    public NewGameButton(MainFrame mFrame){
        this.setText("New Game");
        this.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mFrame.setContentPane(MainFrame.START_NEW_GAME_MENU);
            }
            
        });
    }
}
