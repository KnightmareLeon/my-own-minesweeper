package main.menu.start;

import main.frames.MainFrame;
import main.game.GamePanel;
import main.menu.MenuButton;
import main.sound.Sound;

public abstract class StartNewGameButton extends MenuButton{
    private GamePanel gPanel;
    public StartNewGameButton(MainFrame mFrame, GamePanel gPanel, Sound sound){
        super(mFrame, sound);
        this.gPanel = gPanel;
    }

    protected void startNewGame(byte difficulty){
        this.gPanel.setUp(difficulty);
        goToPanel(MainFrame.GAME);
    }

}
