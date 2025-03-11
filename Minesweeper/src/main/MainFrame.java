package main;

import javax.swing.JFrame;

import main.game.GamePanel;
import main.menu.main.MainMenuPanel;
import main.menu.start.StartNewGameMenuPanel;
import main.stats.StatsPanel;

public class MainFrame extends JFrame{
    private GamePanel gPanel = new GamePanel(this);
    private StartNewGameMenuPanel sGMPanel = new StartNewGameMenuPanel(this, gPanel);
    private MainMenuPanel mMPanel = new MainMenuPanel(this, gPanel);
    private StatsPanel sPanel = new StatsPanel(this);

    public static final byte MAIN_MENU = 0;
    public static final byte START_NEW_GAME_MENU = 1;
    public static final byte GAME = 2;
    public static final byte STATS = 3;

    public MainFrame(){
        this.setSize(800,800);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Minesweeper");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void setContentPane(byte value){
        switch(value){
            case MAIN_MENU:
                this.setContentPane(mMPanel);break;
            case START_NEW_GAME_MENU:
                this.setContentPane(sGMPanel);break;
            case GAME:
                this.setContentPane(gPanel);break;
            case STATS:
                this.setContentPane(sPanel);break;
        }
        this.revalidate();
        this.repaint();
    }
}
