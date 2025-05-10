package main.menu.settings;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import main.frames.MainFrame;
import main.game.GamePanel;
import main.menu.MainMenuButton;
import main.menu.MenuPanel;
import main.sound.Sound;

public class SettingsPanel extends MenuPanel{

    private JLabel currentChangeToolKey;
    private JLabel volumeLabel;

    private ChangeToolKeyButton cToolKeyButton;
    private VolumeDownButton volumeDownButton;
    private VolumeUpButton volumeUpButton;

    private MainMenuButton mMButton;
    public SettingsPanel(MainFrame mFrame, GamePanel gPanel, Sound sound){
        this.mMButton = new MainMenuButton(mFrame, sound);
        
        this.currentChangeToolKey = new JLabel("Change Tool Key: " + 
            KeyEvent.getKeyText(gPanel.getChangeToolKeyCode()));
        this.cToolKeyButton = new ChangeToolKeyButton(mFrame, currentChangeToolKey, gPanel, sound);

        this.volumeLabel = new JLabel(String.format("Volume: %d", (int) sound.getVolume() * 10 ));
        this.volumeDownButton = new VolumeDownButton(volumeLabel, sound);
        this.volumeUpButton = new VolumeUpButton(volumeLabel, sound);

        final JPanel volumeControllers = new JPanel(new FlowLayout(FlowLayout.LEADING));
        volumeControllers.setBackground(new Color(218, 218, 218));
        volumeControllers.add(volumeLabel);
        volumeControllers.add(volumeDownButton);
        volumeControllers.add(volumeUpButton);

        this.addComponent(currentChangeToolKey);
        this.addComponent(cToolKeyButton);
        this.addComponent(volumeControllers);
        this.addComponent(mMButton);
        this.setUpFont(this);
    }
}
