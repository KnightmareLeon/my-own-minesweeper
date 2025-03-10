package main.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;

public class ToolButton extends JToggleButton{
    private final byte SIZE = 50;
    public ToolButton(GamePanel gPanel, byte tool, Image image){
        this.setPreferredSize(new Dimension(SIZE,SIZE));
        this.setBackground(new Color(209, 208, 206));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        this.setFocusPainted(false);
        Image scaledImg = image.getScaledInstance(SIZE, SIZE, Image.SCALE_SMOOTH);
        this.setIcon(new ImageIcon(scaledImg));
        this.addActionListener(e -> gPanel.setTool(tool));
        if(tool == GamePanel.SHOVEL){this.setSelected(true);}
 
    }

}
