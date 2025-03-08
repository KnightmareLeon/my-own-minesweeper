package main.menu.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.MainFrame;
import main.menu.MenuButton;

public class ContinueGameButton extends MenuButton{
    public ContinueGameButton(MainFrame mFrame){
        this.setText("Continue Game");
        this.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e){
                mFrame.setContentPane(MainFrame.GAME);
            }
        });
    }

}
