package main.game;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.plaf.metal.MetalButtonUI;

import main.DefaultButton;

public class GridButton extends DefaultButton{
    private boolean mine = false; 
    private boolean flagged = false;

    private byte adjMines = 0;
    private byte row, col;

    private Image mineImage;
    public GridButton(GamePanel gPanel, byte row, byte col){
        this.row = row;
        this.col = col;
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        this.setUI(new MetalButtonUI(){
            @Override
            protected Color getDisabledTextColor(){
                return Color.BLACK;
            }
        });
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

    public void setMineImage(Image mineImage, byte size){
        Image scaledMineImage = mineImage.getScaledInstance(500 / size, 500 / size, Image.SCALE_SMOOTH);
        this.mineImage = scaledMineImage;
    }

    public void disableGridButton(){
        this.setBackground(new Color(211, 211, 211));
        this.setBorder(null);
        this.setEnabled(false);
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
            setMineIcon();
            gPanel.gameOver();
        } else if(adjMines > 0){
            setText(Byte.toString(adjMines));
        } else {
            gPanel.clearNoAdjMines(row, col);
        }
        

        gPanel.setClickedButtons();
    }

    public void setMineIcon(){
        this.setIcon(new ImageIcon(mineImage));
        this.setDisabledIcon(new ImageIcon(mineImage));
    }

    
}
