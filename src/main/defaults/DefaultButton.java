package main.defaults;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.KeyStroke;

import main.sound.Sound;

public abstract class DefaultButton extends JButton{
    protected final Color DEFAULT_COLOR = new Color(209, 208, 206);
    protected final Color DEFAULT_HOVER_COLOR = DEFAULT_COLOR.darker();

    protected final MouseAdapter DEFAULT_HOVER_BEHAVIOR = new MouseAdapter() {
        @Override
            public void mouseEntered(MouseEvent e){
                DefaultButton.this.setBackground(DEFAULT_HOVER_COLOR);
            }
        @Override
        public void mouseExited(MouseEvent e){
            DefaultButton.this.setBackground(DEFAULT_COLOR);
        }
    };

    private Sound sound;
    public DefaultButton(Sound sound){
        this.sound = sound;
        this.setBackground(DEFAULT_COLOR);
        this.setFocusPainted(false);
        this.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "none");
        this.addMouseListener(DEFAULT_HOVER_BEHAVIOR);
    }

    protected void playSound(){
        sound.playButtonSound();
    }
}
