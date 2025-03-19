package main.menu.settings;

import main.defaults.DefaultPanel;
import main.frames.MainFrame;
import main.menu.MainMenuButton;

public class SettingsPanel extends DefaultPanel{
    private MainMenuButton mMButton;

    public SettingsPanel(MainFrame mFrame){
        this.mMButton = new MainMenuButton(mFrame);

        this.add(mMButton);
        this.setUpFont(this);
    }
}
