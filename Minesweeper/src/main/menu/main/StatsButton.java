package main.menu.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.frames.MainFrame;
import main.menu.MenuButton;

public class StatsButton extends MenuButton{
    public StatsButton(MainFrame mFrame){
        this.setText("Stats");
        this.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                mFrame.setContentPane(MainFrame.STATS);
                playSound();
            }
        });
    }
}
