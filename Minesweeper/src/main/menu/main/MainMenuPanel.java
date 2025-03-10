package main.menu.main;

import main.MainFrame;
import main.game.GamePanel;
import main.menu.MenuPanel;

public class MainMenuPanel extends MenuPanel{
    private ContinueGameButton conGameButton;
    private NewGameButton newGameButton;
    private StatsButton statsButton;
    
    public MainMenuPanel(MainFrame mFrame, GamePanel gPanel){
        this.conGameButton = new ContinueGameButton(mFrame, gPanel);
        this.newGameButton = new NewGameButton(mFrame);
        this.statsButton = new StatsButton();
        this.addButton(conGameButton);
        this.addButton(newGameButton);
        this.addButton(statsButton);
        this.setUpFont(this);
    }
}
