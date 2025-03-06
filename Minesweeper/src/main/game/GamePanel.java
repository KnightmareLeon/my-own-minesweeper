package main.game;

import java.awt.GridLayout;

import main.DefaultPanel;

public class GamePanel extends DefaultPanel{
    private GridLayout grid;
    private boolean firstCLickDone = false;
    private GridButton[][] buttons;
    private byte mines = 0;
    public static final byte EASY = 0;
    public static final byte NORMAL = 1;
    public static final byte HARD = 2; 
    
    private byte difficulty;

    public GamePanel(){
        
    }

    public void setUpButtons(byte difficulty){
        this.difficulty = difficulty;
        byte size = 0;
        switch(difficulty){
            case EASY:
                size = 9;
                break;
            case NORMAL:
                size = 16;
                break;
            case HARD: 
                size = 30;
                break;
        }

        buttons = new GridButton[size][size];
        grid = new GridLayout(size, size);
        this.setLayout(grid);
        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                buttons[row][col] = new GridButton(this, row, col);
                this.add(buttons[row][col]);
            }
        }

        this.setUpFont();
    }

    public boolean isFirstClickDone(){return firstCLickDone;}

    public void firstClickDone(){this.firstCLickDone = true;}

    public void setMines(int rowFirst, int colFirst){
        switch(this.difficulty){
            case EASY:
                mines = 10;
                break;
            case NORMAL:
                mines = 40;
                break;
            case HARD:
                mines = 99;
                break;
        }

        for(byte mine = 0; mine < mines;){
            int row = (int) (Math.random() * buttons.length);
            int col = (int) (Math.random() * buttons.length);
            
            if(!buttons[row][col].hasMine() && row != rowFirst && col != colFirst
                && !isAdjToFirstClick(buttons[row][col], buttons[rowFirst][colFirst])){
                buttons[row][col].setMine();
                mines++;
            }
        }
    }

    public void setAllAdjMines(int rowFirst, int colFirst){
        for(int row = 0; row < buttons.length; row++){
            for(int col = 0; col < buttons.length; col++){
                byte adjMines = 0;
                if(buttons[row][col].hasMine() || (row == rowFirst && col == colFirst)){
                    col++;
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
