package main.game;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GamePanel extends JPanel{
    private GridLayout grid;
    public GamePanel(){
        
    }

    public void setUpButtons(int size){
        JButton[][] buttons = new JButton[size][size];
        grid = new GridLayout(size, size);
        this.setLayout(grid);
        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                buttons[row][col] = new GridButton();
                this.add(buttons[row][col]);
            }
        }
    }
}
