package main.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.MainFrame;

public class MainMenuButton extends MenuButton{
    public MainMenuButton(MainFrame mFrame){
        super();
        this.setText("Main Menu");
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                mFrame.setContentPane(MainFrame.MAIN_MENU);
            }
        });
    }
}
