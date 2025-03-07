package main.menu.start;

import main.MainFrame;
import main.game.GamePanel;
import main.menu.BackButton;
import main.menu.MenuPanel;

public class StartNewGameMenuPanel extends MenuPanel{
    private StartEasyGameButton eGButton;
    private StartNormalGameButton nGButton;
    private StartHardGameButton hGButton;
    private BackButton back;
    public StartNewGameMenuPanel(MainFrame mFrame, GamePanel gPanel){
        eGButton = new StartEasyGameButton(mFrame, gPanel);
        nGButton = new StartNormalGameButton(mFrame, gPanel);
        hGButton = new StartHardGameButton(mFrame, gPanel);
        back = new BackButton(mFrame);
        this.addButton(eGButton);
        this.addButton(nGButton);
        this.addButton(hGButton);
        this.addButton(back);
        this.setUpFont(this);
    }
}
