package main.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.MainFrame;

public class BackButton extends MenuButton{
    public BackButton(MainFrame mFrame){
        super();
        this.setText("Back");
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                mFrame.setContentPane(MainFrame.MAIN_MENU);
            }
        });
    }
}
