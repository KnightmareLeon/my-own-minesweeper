package main.menu.main;

import main.frames.MainFrame;
import main.game.GamePanel;
import main.menu.MenuPanel;

public class MainMenuPanel extends MenuPanel{
    private ContinueGameButton conGameButton;
    private NewGameButton newGameButton;
    private StatsButton statsButton;
    private SettingsButton setsButton;
    public MainMenuPanel(MainFrame mFrame, GamePanel gPanel){
        this.conGameButton = new ContinueGameButton(mFrame, gPanel);
        this.newGameButton = new NewGameButton(mFrame);
        this.statsButton = new StatsButton(mFrame);
        this.setsButton = new SettingsButton(mFrame);
        this.addButton(conGameButton);
        this.addButton(newGameButton);
        this.addButton(statsButton);
        this.addButton(setsButton);
        this.setUpFont(this);
    }
}
