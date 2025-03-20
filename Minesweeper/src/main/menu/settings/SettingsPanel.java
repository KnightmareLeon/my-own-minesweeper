package main.menu.settings;

import main.frames.MainFrame;
import main.menu.MainMenuButton;
import main.menu.MenuPanel;

public class SettingsPanel extends MenuPanel{
    private MainMenuButton mMButton;

    public SettingsPanel(MainFrame mFrame){
        this.mMButton = new MainMenuButton(mFrame);

        this.addComponent(mMButton);
        this.setUpFont(this);
    }
}
