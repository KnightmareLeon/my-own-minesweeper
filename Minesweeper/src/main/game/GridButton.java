package main.game;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

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
    private Image flagImage;
    public GridButton(GamePanel gPanel, byte row, byte col){
        this.row = row;
        this.col = col;
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        this.setUI(new MetalButtonUI(){
            @Override
            protected Color getDisabledTextColor(){
                switch(adjMines){
                    case 1: return Color.BLUE;
                    case 2: return Color.GREEN;
                    case 3: return Color.RED;
                    case 4: return Color.BLUE.darker();
                    case 5: return new Color(150, 75, 0); //Brown
                    case 6: return Color.CYAN;
                    case 7: return Color.BLACK;
                    case 8: return Color.GRAY;
                    default: return Color.WHITE;
                }
            }
        });
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                clicked(gPanel);
            }
        });

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if(!isEnabled()){
                    setBackground(new Color(250, 250, 250));
                    return;
                }
                if(gPanel.getTool() == GamePanel.FLAG){
                    setBorder(BorderFactory.createLineBorder(Color.RED, 6));
                } else {
                    setBorder(BorderFactory.createLineBorder(Color.BLACK, 6));
                }
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if(!isEnabled()){
                    setBackground(new Color(250, 250, 250));
                    return;
                }
                setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
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

    public void setFlagImage(Image flagImage, byte size){
        Image scaledFlagImage = flagImage.getScaledInstance(500 / size, 500 / size, Image.SCALE_SMOOTH);
        this.flagImage = scaledFlagImage;
    }

    public void disableGridButton(){
        this.setBackground(new Color(250, 250, 250));
        this.setBorder(null);
        this.setEnabled(false);
    }

    public void clicked(GamePanel gPanel){
        if(gPanel.getTool() == GamePanel.FLAG && gPanel.isFirstClickDone()){
            if(!flagged){
                setIcon(new ImageIcon(flagImage));
                gPanel.updateMines(GamePanel.DECREMENT);
                flagged = true;
            } else {
                setIcon(null);
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
        gPanel.revalidate();
        gPanel.repaint();
    }

    public void setMineIcon(){
        this.setIcon(new ImageIcon(mineImage));
        this.setDisabledIcon(new ImageIcon(mineImage));
    }

    public void setFlagIcon(){
        this.setIcon(new ImageIcon(flagImage));
        this.setDisabledIcon(new ImageIcon(flagImage));
    }
}
