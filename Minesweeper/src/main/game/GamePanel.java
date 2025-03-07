package main.game;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import main.DefaultPanel;

public class GamePanel extends DefaultPanel{
    private GridLayout grid;
    private GridButton[][] buttons;
    private JPanel gridPanel = new JPanel();    
    private JLabel minesLabel = new JLabel();

    private boolean firstCLickDone = false;
    private byte mines = 0;

    public static final byte EASY = 0;
    public static final byte NORMAL = 1;
    public static final byte HARD = 2; 
    
    

    public GamePanel(){
        this.setLayout(new BorderLayout());
        this.add(minesLabel, BorderLayout.NORTH);
        this.add(gridPanel, BorderLayout.CENTER);
    }

    public void setUp(byte difficulty){
        byte size = 0;
        switch(difficulty){
            case EASY:
                size = 9; mines = 10; minesLabel.setText("Mines: 10");
                break;
            case NORMAL:
                size = 16; mines = 40; minesLabel.setText("Mines: 40");
                break;
            case HARD: 
                size = 30; mines = 99; minesLabel.setText("Mines: 99");
                break;
        }

        buttons = new GridButton[size][size];
        grid = new GridLayout(size, size);
        gridPanel.setLayout(grid);
        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                buttons[row][col] = new GridButton(this, row, col);
                gridPanel.add(buttons[row][col]);
            }
        }
        switch(difficulty){
            case EASY:
            case NORMAL:
                this.setUpFont(this);
                break;
            case HARD:
                this.setUpFont(this,15);
                break;
        }
    }

    public boolean isFirstClickDone(){return firstCLickDone;}

    public void firstClickDone(){this.firstCLickDone = true;}

    public void setMines(int rowFirst, int colFirst){
        for(byte mine = 0; mine < mines;){
            int row = (int) (Math.random() * buttons.length);
            int col = (int) (Math.random() * buttons.length);
            
            if(!buttons[row][col].hasMine() && row != rowFirst && col != colFirst
                && !isAdjToFirstClick(buttons[row][col], buttons[rowFirst][colFirst])){
                buttons[row][col].setMine();
                mine++;
                
            }
        }
    }

    public void setAllAdjMines(int rowFirst, int colFirst){
        for(int row = 0; row < buttons.length; row++){
            for(int col = 0; col < buttons.length; col++){
                byte adjMines = 0;
                if(buttons[row][col].hasMine() || (row == rowFirst && col == colFirst)){
                    continue;
                } else {
                    for(GridButton adjButton : getAdjacentButtons(buttons[row][col])){
                        if(adjButton != null && adjButton.hasMine()){
                            adjMines++;
                        }
                    }
                    buttons[row][col].setAdjMines(adjMines);
                }
                
            }
        }
    }
    
    public void clearNoAdjMines(int row, int col){
        GridButton button = buttons[row][col];
        if(button.getAdjMines() == 0 && !button.hasMine()){
            for(GridButton adjButton : getAdjacentButtons(button)){
                if(adjButton != null && adjButton.isEnabled()){
                    adjButton.doClick();
                    clearNoAdjMines(adjButton.getRow(), adjButton.getCol());
                }
            }
        } else if(button.getAdjMines() > 0){
            button.doClick();
        } 
    }

    public GridButton[] getAdjacentButtons(GridButton button){
        GridButton[] adjacentButtons = new GridButton[8];
        int index = 0;
        for(int r = button.getRow() - 1; r <= button.getRow() + 1; r++){
            for(int c = button.getCol() - 1; c <= button.getCol() + 1; c++){
                if(r >= 0 && r < buttons.length && c >= 0 && c < buttons.length &&
                   (r != button.getRow() || c != button.getCol())){
                    adjacentButtons[index++] = buttons[r][c];
                }
            }
        }
        return adjacentButtons;
    }

    public boolean isAdjToFirstClick(GridButton button, GridButton firstClick){
        for(GridButton adjButton : this.getAdjacentButtons(button)){
            if(adjButton != null && adjButton == firstClick){
                return true;
            }
        }
        return false;
    }
    
}
