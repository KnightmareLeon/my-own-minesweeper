package main.menu.start;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.MainFrame;
import main.game.GamePanel;

public class StartNormalGameButton extends StartNewGameButton{
    public StartNormalGameButton(MainFrame mFrame, GamePanel gamePanel){
        super(mFrame, gamePanel);
        this.setText("Normal");
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                startNewGame(16);
            }
        });
    }

}
