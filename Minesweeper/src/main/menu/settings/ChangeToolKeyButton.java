package main.menu.settings;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;

import main.defaults.DefaultButton;
import main.game.GamePanel;

public class ChangeToolKeyButton extends DefaultButton{
    private KeyListener changeToolkeyListener; 

    public ChangeToolKeyButton(JLabel currentChangeToolKey, GamePanel gPanel){
        this.setText("Change Tool Key");
        this.changeToolkeyListener = new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                currentChangeToolKey.setText("Change Tool Key: " + e.getKeyChar());
                gPanel.setChangeToolKey(Character.toString(e.getKeyChar()));
                removeKeyListener();
            }
    
            @Override
            public void keyPressed(KeyEvent e) {
                throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
            }
    
            @Override
            public void keyReleased(KeyEvent e) {
                throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
            }
            
            private void removeKeyListener(){
                currentChangeToolKey.removeKeyListener(this);
            }
        };

    }
}
