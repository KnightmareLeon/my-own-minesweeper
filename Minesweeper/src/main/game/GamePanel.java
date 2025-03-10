package main.game;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.DefaultPanel;
import main.MainFrame;
import main.menu.MainMenuButton;
import main.menu.main.NewGameButton;

public class GamePanel extends DefaultPanel{
    
    private Toolkit toolkit = Toolkit.getDefaultToolkit();
    private Image shovelImage = toolkit.getImage("src/resources/images/Shovel.gif");
    private Image flagImage = toolkit.getImage("src/resources/images/Flag.png");
    
    private JPanel topPanel = new JPanel();
    private MainMenuButton mainMenuButton;
    private NewGameButton newGameButton;
    private ToolButton shovelButton = new ToolButton(this, GamePanel.SHOVEL, shovelImage);
    private ToolButton flagButton = new ToolButton(this, GamePanel.FLAG, flagImage);
    private ButtonGroup toolButtonGroup = new ButtonGroup();
    private JLabel minesLabel = new JLabel();

    private JPanel gridPanel = new JPanel();
    private GridLayout grid;
    private GridButton[][] buttons;
    
    private Cursor shovelCursor;
    private Cursor flagCursor;

    private boolean firstCLickDone = false;
    private byte mines = 0;
    private byte tool = 0;

    public static final byte SHOVEL = 0;
    public static final byte FLAG = 1;

    public static final byte SET = 0;
    public static final byte INCREMENT = 1;
    public static final byte DECREMENT = 2;

    public static final byte EASY = 0;
    public static final byte NORMAL = 1;
    public static final byte HARD = 2; 
    
    public GamePanel(MainFrame mFrame){
        this.setLayout(new BorderLayout());
        
        mainMenuButton = new MainMenuButton(mFrame);
        newGameButton = new NewGameButton(mFrame);
        
        mainMenuButton.setPreferredSize(new Dimension(100, 50));
        newGameButton.setPreferredSize(new Dimension(100, 50));
        
        mainMenuButton.setText("Main");
        newGameButton.setText("New");

        shovelCursor = toolkit.createCustomCursor(
            shovelImage, 
            new Point(gridPanel.getX(),gridPanel.getY()), 
            "shovel");
        flagCursor = toolkit.createCustomCursor(
            flagImage, 
            new Point(gridPanel.getX(),gridPanel.getY()), 
            "flag");
        
        gridPanel.setCursor(shovelCursor);

        toolButtonGroup.add(shovelButton);
        toolButtonGroup.add(flagButton);

        topPanel.add(mainMenuButton);
        topPanel.add(newGameButton);
        topPanel.add(shovelButton);
        topPanel.add(flagButton);
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
                size = 9; mines = 10; 
                break;
            case NORMAL:
                size = 16; mines = 40;
                break;
            case HARD: 
                size = 30; mines = 99;
                break;
        }
        this.updateMines(SET);
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
                this.setUpFont(this, 20);
                break;
            case HARD:
                this.setUpFont(topPanel,20);
                this.setUpFont(gridPanel,15);
                break;
        }
    }

    public boolean isFirstClickDone(){return firstCLickDone;}

    public void firstClickDone(){this.firstCLickDone = true;}

    public void updateMines(byte action){
        switch(action){
            case INCREMENT:
                mines++;
                break;
            case DECREMENT:
                mines--;
                break;
        }
        minesLabel.setText("Mines: " + mines);
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
    
    public void setTool(byte tool){
        this.tool = tool;
        switch(this.tool){
            case SHOVEL:
                gridPanel.setCursor(shovelCursor);
                break;
            case FLAG:
                gridPanel.setCursor(flagCursor);
                break;
        }
    }

    public byte getTool(){return this.tool;}

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

    public void gameOver(){
        for(byte row = 0; row < buttons.length; row++){
            for(byte col = 0; col < buttons.length; col++){
                if(buttons[row][col].hasMine()){
                    buttons[row][col].disableGridButton();
                    buttons[row][col].setText("X");
                } else {
                    buttons[row][col].setEnabled(false);
                }
            }
        }
    }
    
}
