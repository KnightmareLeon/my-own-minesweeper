package main.game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;

import main.DefaultButton;

public class GridButton extends DefaultButton{
    private boolean mine = false;
    private boolean firstClick = false;
    public GridButton(GamePanel gPanel){
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                setBackground(Color.LIGHT_GRAY);
                setEnabled(false);
                setBorder(null);
                if(!gPanel.isFirstClickDone()){
                    firstClick = true;
                    gPanel.firstClickDone();
                    gPanel.setMines();
                }
                if(hasMine()){
                    setText("X");
                }
            }
        });
    }

    public boolean hasMine(){return this.mine;}

    public boolean isFirstClick(){return this.firstClick;}
    
    public void setMine(){
        this.mine = true;
    }
}
