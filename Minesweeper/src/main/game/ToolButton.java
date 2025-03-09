package main.game;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JToggleButton;

public class ToolButton extends JToggleButton{
    public ToolButton(GamePanel gPanel, byte tool){
        this.setPreferredSize(new Dimension(50,50));
        this.setBackground(new Color(209, 208, 206));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        this.setFocusPainted(false);
        if(tool == GamePanel.SHOVEL){
            this.setText("S");
            this.addActionListener(e -> gPanel.setTool(GamePanel.SHOVEL));
            this.setSelected(true);
        }else if(tool == GamePanel.FLAG){
            this.setText("F");
            this.addActionListener(e -> gPanel.setTool(GamePanel.FLAG));
        }
 
    }

}
