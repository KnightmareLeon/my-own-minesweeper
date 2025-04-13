package main.menu.settings;

import java.awt.event.KeyEvent;

import javax.swing.JLabel;

import main.frames.MainFrame;
import main.game.GamePanel;
import main.menu.MainMenuButton;
import main.menu.MenuPanel;

public class SettingsPanel extends MenuPanel{
    private JLabel currentChangeToolKey;
    private JLabel volume = new JLabel("Volume:");
    private ChangeToolKeyButton cToolKeyButton;
    private MainMenuButton mMButton;
    public SettingsPanel(MainFrame mFrame, GamePanel gPanel){
        this.mMButton = new MainMenuButton(mFrame);
        this.currentChangeToolKey = new JLabel("Change Tool Key: " + 
            KeyEvent.getKeyText(gPanel.getChangeToolKeyCode()));
        this.cToolKeyButton = new ChangeToolKeyButton(mFrame, currentChangeToolKey, gPanel);
        this.addComponent(currentChangeToolKey);
        this.addComponent(cToolKeyButton);
        this.addComponent(volume);
        this.addComponent(mMButton);
        this.setUpFont(this);
    }
}
