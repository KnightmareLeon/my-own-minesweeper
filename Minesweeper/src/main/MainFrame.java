package main;

import javax.swing.JFrame;

import main.game.GamePanel;
import main.menu.main.MainMenuPanel;
import main.menu.start.StartNewGameMenuPanel;

public class MainFrame extends JFrame{
    private GamePanel gPanel = new GamePanel();
    private StartNewGameMenuPanel sGMPanel = new StartNewGameMenuPanel(this, gPanel);
    private MainMenuPanel mMPanel = new MainMenuPanel(this);
    public MainFrame(){
        this.setSize(500,500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Minesweeper");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void setContentPane(int value){
        switch(value){
            case 0:
                this.setContentPane(mMPanel);break;
            case 1:
                this.setContentPane(sGMPanel);break;
            case 2:
                this.setContentPane(gPanel);break;
        }
        this.revalidate();
        this.repaint();
    }
}
