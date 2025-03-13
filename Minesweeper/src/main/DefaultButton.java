package main;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public abstract class DefaultButton extends JButton{
    private final Color DEFAULT_COLOR = new Color(209, 208, 206);
    private final Color HOVER_COLOR = DEFAULT_COLOR.darker();
    public DefaultButton(){
        this.setBackground(DEFAULT_COLOR);
        this.setFocusPainted(false);
        this.setFocusable(false);
        this.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                DefaultButton.this.setBackground(HOVER_COLOR);
            }
            @Override
            public void mouseExited(MouseEvent e){
                DefaultButton.this.setBackground(DEFAULT_COLOR);
            }
        });
    }
}
