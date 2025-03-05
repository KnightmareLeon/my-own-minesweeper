package main.game;

import java.awt.GridLayout;

import main.DefaultPanel;

public class GamePanel extends DefaultPanel{
    private GridLayout grid;
    private boolean firstCLickDone = false;
    private GridButton[][] buttons;
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
                buttons[row][col] = new GridButton(this);
                this.add(buttons[row][col]);
            }
        }

        this.setUpFont();
    }

    public boolean isFirstClickDone(){return firstCLickDone;}

    public void firstClickDone(){this.firstCLickDone = true;}
    public void setMines(){
        byte mines = 0;
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
            
            if(!buttons[row][col].hasMine() && !buttons[row][col].isFirstClick()){
                buttons[row][col].setMine();
                mines++;
            }
        }
    }
    
}
