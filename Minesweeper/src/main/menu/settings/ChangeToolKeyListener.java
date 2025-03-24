package main.menu.settings;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.KeyStroke;

import main.frames.MainFrame;
import main.game.GamePanel;

public class ChangeToolKeyListener extends KeyAdapter {
    private MainFrame mFrame;
    private JLabel currentChangeToolKey;
    private GamePanel gPanel;
    public ChangeToolKeyListener(MainFrame mFrame, JLabel currentChangeToolKey, GamePanel gPanel){
        this.mFrame = mFrame;
        this.currentChangeToolKey = currentChangeToolKey;
        this.gPanel = gPanel;
    }
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(keyCode >= 32 && keyCode <= 126){
            System.out.println(e.getKeyCode());
            currentChangeToolKey.setText("Change Tool Key: " + KeyEvent.getKeyText(keyCode));
            gPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).remove(KeyStroke.getKeyStroke(gPanel.getChangeToolKey(), 0));
            gPanel.setChangeToolKey(keyCode);
            gPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(keyCode, 0), "change tool");
            removeSelf();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    private void removeSelf(){
        mFrame.removeKeyListener(this);
        mFrame.setFocusable(false);
    }

}
