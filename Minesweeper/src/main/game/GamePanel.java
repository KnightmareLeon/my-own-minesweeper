package main.game;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import main.DefaultPanel;
import main.MainFrame;
import main.menu.MainMenuButton;

public class GamePanel extends DefaultPanel{
    
    private JPanel topPanel = new JPanel();
    private MainMenuButton backButton;
    private JLabel minesLabel = new JLabel();

    private GridLayout grid;
    private GridButton[][] buttons;
    private JPanel gridPanel = new JPanel();    

    private boolean firstCLickDone = false;
    private byte mines = 0;

    public static final byte EASY = 0;
    public static final byte NORMAL = 1;
    public static final byte HARD = 2; 
    
    public GamePanel(MainFrame mFrame){
        this.setLayout(new BorderLayout());
        backButton = new MainMenuButton(mFrame);
        topPanel.add(backButton);
        topPanel.add(minesLabel);
        this.add(topPanel, BorderLayout.NORTH);
        this.add(gridPanel, BorderLayout.CENTER);
    }

    public void setUp(byte difficulty){
        gridPanel.removeAll();
        firstCLickDone = false;
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
        for(byte row = 0; row < size; row++){
            for(byte col = 0; col < size; col++){
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

    public void setMines(byte rowFirst, byte colFirst){
        for(byte mine = 0; mine < mines;){
            byte row = (byte) (Math.random() * buttons.length);
            byte col = (byte) (Math.random() * buttons.length);
            
            if(!buttons[row][col].hasMine() && row != rowFirst && col != colFirst
                && !isAdjToFirstClick(buttons[row][col], buttons[rowFirst][colFirst])){
                buttons[row][col].setMine();
                mine++;
                
            }
        }
    }

    public void setAllAdjMines(int rowFirst, int colFirst){
        for(byte row = 0; row < buttons.length; row++){
            for(byte col = 0; col < buttons.length; col++){
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
    
    public void clearNoAdjMines(byte row, byte col){
        GridButton button = buttons[row][col];
        if(!button.hasMine()){
            for(GridButton adjButton : getAdjacentButtons(button)){
                if(adjButton != null && adjButton.isEnabled()){
                    adjButton.clicked(this);
                }
            }
        }
    }

    public GridButton[] getAdjacentButtons(GridButton button){
        GridButton[] adjacentButtons = new GridButton[8];
        byte index = 0;
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

    public void gameOver(){
        for(byte row = 0; row < buttons.length; row++){
            for(byte col = 0; col < buttons.length; col++){
                if(buttons[row][col].hasMine()){
                    buttons[row][col].changeButton();
                    buttons[row][col].setText("X");
                } else {
                    buttons[row][col].setEnabled(false);
                }
            }
        }
    }
    
}
