package main.menu.start;

import main.frames.MainFrame;
import main.game.GamePanel;
import main.menu.MainMenuButton;
import main.menu.MenuPanel;
import main.sound.Sound;

public class StartNewGameMenuPanel extends MenuPanel{
    private StartEasyGameButton eGButton;
    private StartNormalGameButton nGButton;
    private StartHardGameButton hGButton;
    private MainMenuButton back;
    public StartNewGameMenuPanel(MainFrame mFrame, GamePanel gPanel, Sound sound){
        eGButton = new StartEasyGameButton(mFrame, gPanel, sound);
        nGButton = new StartNormalGameButton(mFrame, gPanel, sound);
        hGButton = new StartHardGameButton(mFrame, gPanel, sound);
        back = new MainMenuButton(mFrame, sound);
        this.addComponent(eGButton);
        this.addComponent(nGButton);
        this.addComponent(hGButton);
        this.addComponent(back);
        this.setUpFont(this);
    }
}
