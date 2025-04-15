package main.menu.main;

import main.frames.MainFrame;
import main.game.GamePanel;
import main.menu.MenuPanel;
import main.sound.Sound;

public class MainMenuPanel extends MenuPanel{
    private ContinueGameButton conGameButton;
    private NewGameButton newGameButton;
    private StatsButton statsButton;
    private SettingsButton setsButton;
    public MainMenuPanel(MainFrame mFrame, GamePanel gPanel, Sound sound){
        this.conGameButton = new ContinueGameButton(mFrame, gPanel, sound);
        this.newGameButton = new NewGameButton(mFrame, sound);
        this.statsButton = new StatsButton(mFrame, sound);
        this.setsButton = new SettingsButton(mFrame, sound);
        this.addComponent(conGameButton);
        this.addComponent(newGameButton);
        this.addComponent(statsButton);
        this.addComponent(setsButton);
        this.setUpFont(this);
    }
}
