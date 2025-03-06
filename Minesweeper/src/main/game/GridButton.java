package main.game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;

import main.DefaultButton;

public class GridButton extends DefaultButton{
    private boolean mine = false; 
    private byte adjMines = 0;
    private int row, col;
    public GridButton(GamePanel gPanel, int row, int col){
        this.row = row;
        this.col = col;
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                setBackground(Color.LIGHT_GRAY);
                setEnabled(false);
                setBorder(null);
                if(!gPanel.isFirstClickDone()){
                    gPanel.firstClickDone();
                    gPanel.setMines(getRow(), getCol());
                    gPanel.setAllAdjMines(getRow(), getCol());
                } else if(hasMine()){
                    setText("X");
                } else if(adjMines > 0){
                    setText(Byte.toString(adjMines));
                } 
            }
        });
    }

    public boolean hasMine(){return this.mine;}
    
    public void setMine(){this.mine = true;}

    public int getRow(){return this.row;}

    public int getCol(){return this.col;}

    public void setAdjMines(byte adjMines){this.adjMines = adjMines;}
}
