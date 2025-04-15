package main.menu.start;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.frames.MainFrame;
import main.game.GamePanel;
import main.sound.Sound;

public class StartHardGameButton extends StartNewGameButton{
    public StartHardGameButton(MainFrame mFrame, GamePanel gamePanel, Sound sound){
        super(mFrame, gamePanel, sound);
        this.setText("Hard");
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                startNewGame(GamePanel.HARD);
            }
        });
    }

}
