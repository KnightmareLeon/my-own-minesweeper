package main.menu.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.frames.MainFrame;
import main.menu.MenuButton;
import main.sound.Sound;

public class StatsButton extends MenuButton{
    public StatsButton(MainFrame mFrame, Sound sound){
        super(mFrame, sound);
        this.setText("Stats");
        this.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                goToPanel(MainFrame.STATS);
            }
        });
    }
}
