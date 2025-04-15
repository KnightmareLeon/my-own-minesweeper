package main.menu.settings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import main.frames.MainFrame;
import main.game.GamePanel;
import main.menu.MenuButton;
import main.sound.Sound;

public class ChangeToolKeyButton extends MenuButton{
    private ChangeToolKeyListener cToolKeyListener;
    public ChangeToolKeyButton(MainFrame mFrame, JLabel currentChangeToolKey, GamePanel gPanel, Sound sound){
        super(mFrame, sound);
        cToolKeyListener = new ChangeToolKeyListener(mFrame, currentChangeToolKey, gPanel);
        this.setText("Change Tool Key");
        this.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mFrame.setFocusable(true);
                mFrame.addKeyListener(cToolKeyListener);
                mFrame.requestFocus();
                System.out.println("Working");
            }
            
        });
    }
}
