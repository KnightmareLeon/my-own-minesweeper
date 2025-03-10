package main.game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;

import main.DefaultButton;

public class GridButton extends DefaultButton{
    private boolean mine = false; 
    private boolean flagged = false;
    private byte adjMines = 0;
    private byte row, col;
    public GridButton(GamePanel gPanel, byte row, byte col){
        this.row = row;
        this.col = col;
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                clicked(gPanel);
            }
        });
    }

    public boolean hasMine(){return this.mine;}
    
    public void setMine(){this.mine = true;}

    public byte getRow(){return this.row;}

    public byte getCol(){return this.col;}

    public void setAdjMines(byte adjMines){this.adjMines = adjMines;}

    public byte getAdjMines(){return this.adjMines;}

    public void disableGridButton(){
        this.setBackground(Color.LIGHT_GRAY);
        this.setEnabled(false);
        this.setBorder(null);
    }

    public void clicked(GamePanel gPanel){
        if(gPanel.getTool() == GamePanel.FLAG && gPanel.isFirstClickDone()){
            if(!flagged){
                setText("F");
                gPanel.updateMines(GamePanel.DECREMENT);
                flagged = true;
            } else {
                setText("");
                gPanel.updateMines(GamePanel.INCREMENT);
                flagged = false;
            }
            return;
        }
        else if (gPanel.getTool() == GamePanel.FLAG && !gPanel.isFirstClickDone()){
            return;
        }
        
        this.disableGridButton();
        if(!gPanel.isFirstClickDone()){
            gPanel.firstClickDone();
            gPanel.setMines(getRow(), getCol());
            gPanel.setAllAdjMines(getRow(), getCol());
            gPanel.clearNoAdjMines(row, col);
        } else if(hasMine()){
            setText("X");
            gPanel.gameOver();
        } else if(adjMines > 0){
            setText(Byte.toString(adjMines));
        } else {
            gPanel.clearNoAdjMines(row, col);
        }

        gPanel.setClickedButtons();
    }

    
}
