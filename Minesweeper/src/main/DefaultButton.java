package main;

import java.awt.Color;

import javax.swing.JButton;

public abstract class DefaultButton extends JButton{
    public DefaultButton(){
        this.setBackground(new Color(209, 208, 206));
        this.setFocusPainted(false);
        
    }
}
