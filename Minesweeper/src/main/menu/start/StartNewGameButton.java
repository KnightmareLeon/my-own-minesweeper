package main.menu.start;

import main.frames.MainFrame;
import main.game.GamePanel;
import main.menu.MenuButton;

public abstract class StartNewGameButton extends MenuButton{
    private GamePanel gPanel;
    private MainFrame mFrame;
    public StartNewGameButton(MainFrame mFrame, GamePanel gPanel){
        this.gPanel = gPanel;
        this.mFrame = mFrame;
    }

    protected void startNewGame(byte difficulty){
        this.gPanel.setUp(difficulty);
        mFrame.setContentPane(MainFrame.GAME);
        playSound();
    }

}
