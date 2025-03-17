package main.menu.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.frames.MainFrame;
import main.game.GamePanel;
import main.menu.MenuButton;

public class ContinueGameButton extends MenuButton{
    public ContinueGameButton(MainFrame mFrame, GamePanel gPanel){
        super(mFrame);
        this.setText("Continue Game");
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(gPanel.hasGameStarted()){
                    goToPanel(MainFrame.GAME);
                }
            }
        });
    }

}
