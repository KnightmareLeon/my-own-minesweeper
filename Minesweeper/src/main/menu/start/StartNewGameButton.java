package main.menu.start;

import main.MainFrame;
import main.game.GamePanel;
import main.menu.MenuButton;

public abstract class StartNewGameButton extends MenuButton{
    private GamePanel gPanel;
    private MainFrame mFrame;
    public StartNewGameButton(MainFrame mFrame, GamePanel gPanel){
        this.gPanel = gPanel;
        this.mFrame = mFrame;
    }

    protected void startNewGame(int size){
        this.gPanel.setUpButtons(size);
        mFrame.setContentPane(2);
    }

}
