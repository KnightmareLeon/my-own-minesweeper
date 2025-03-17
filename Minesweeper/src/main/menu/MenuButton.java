package main.menu;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;

import main.defaults.DefaultButton;
import main.frames.MainFrame;

public abstract class MenuButton extends DefaultButton{
    private MainFrame mFrame;
    public MenuButton(MainFrame mFrame){
        this.mFrame = mFrame;
        this.setPreferredSize(new Dimension(500,90));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    }

    protected void goToPanel(byte panel){
        this.playSound();
        this.mFrame.setContentPane(panel);
        this.setBackground(DEFAULT_COLOR);
    }
}
