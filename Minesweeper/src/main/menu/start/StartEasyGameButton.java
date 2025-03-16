package main.menu.start;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.frames.MainFrame;
import main.game.GamePanel;

public class StartEasyGameButton extends StartNewGameButton{
    public StartEasyGameButton(MainFrame mFrame, GamePanel gamePanel){
        super(mFrame, gamePanel);
        this.setText("Easy");
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                startNewGame(GamePanel.EASY);
            }
        });
    }

}
