package main.frames;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import main.game.GamePanel;
import main.menu.main.MainMenuPanel;
import main.menu.settings.SettingsPanel;
import main.menu.start.StartNewGameMenuPanel;
import main.menu.stats.StatsPanel;
import main.sound.Sound;

public class MainFrame extends JFrame{

    private Sound sound = new Sound();
    private StatsPanel sPanel = new StatsPanel(this, sound);
    private GamePanel gPanel = new GamePanel(this, sPanel, sound);
    private StartNewGameMenuPanel sGMPanel = new StartNewGameMenuPanel(this, gPanel, sound);
    private MainMenuPanel mMPanel = new MainMenuPanel(this, gPanel, sound);
    private SettingsPanel setPanel = new SettingsPanel(this, gPanel, sound);

    private Toolkit toolkit = Toolkit.getDefaultToolkit();
    private final int WINDOW_SIZE = toolkit.getScreenSize().height - 50;
    private final Image WINDOW_ICON = toolkit.getImage("src/resources/images/Mine.png");
    
    public static final byte MAIN_MENU = 0;
    public static final byte START_NEW_GAME_MENU = 1;
    public static final byte GAME = 2;
    public static final byte STATS = 3;
    public static final byte SETTINGS = 4;

    public MainFrame(){
        this.setSize(WINDOW_SIZE, WINDOW_SIZE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setIconImage(WINDOW_ICON);
        this.setTitle("Minesweeper");

        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setContentPane(MAIN_MENU);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                sPanel.saveStats();
                System.exit(0);
            }
        });
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
            case SETTINGS:
                this.setContentPane(setPanel);break;
        }
        this.revalidate();
        this.repaint();
    }
}
