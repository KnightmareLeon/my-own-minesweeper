package main.menu.start;

import main.frames.MainFrame;
import main.game.GamePanel;
import main.menu.MainMenuButton;
import main.menu.MenuPanel;

public class StartNewGameMenuPanel extends MenuPanel{
    private StartEasyGameButton eGButton;
    private StartNormalGameButton nGButton;
    private StartHardGameButton hGButton;
    private MainMenuButton back;
    public StartNewGameMenuPanel(MainFrame mFrame, GamePanel gPanel){
        eGButton = new StartEasyGameButton(mFrame, gPanel);
        nGButton = new StartNormalGameButton(mFrame, gPanel);
        hGButton = new StartHardGameButton(mFrame, gPanel);
        back = new MainMenuButton(mFrame);
        this.addComponent(eGButton);
        this.addComponent(nGButton);
        this.addComponent(hGButton);
        this.addComponent(back);
        this.setUpFont(this);
    }
}
