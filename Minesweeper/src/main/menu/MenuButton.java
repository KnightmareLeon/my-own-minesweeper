package main.menu;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;

import main.defaults.DefaultButton;

public abstract class MenuButton extends DefaultButton{
    public MenuButton(){
        this.setPreferredSize(new Dimension(500,90));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    }
}
