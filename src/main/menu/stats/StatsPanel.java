package main.menu.stats;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JLabel;

import main.frames.MainFrame;
import main.game.GamePanel;
import main.menu.MainMenuButton;
import main.menu.MenuPanel;
import main.sound.Sound;

public class StatsPanel extends MenuPanel{
    private final String STATS_FILE_PATH = "src/resources/stats/stats.txt";
    private File statsFile;
    private boolean updatedStats = false;

    private int easyGamesPlayed, normalGamesPlayed, hardGamesPlayed;
    private int easyWins, normalWins, hardWins;
    private int easyFastestTime, normalFastestTime, hardFastestTime;

    private JLabel easyGamesPlayedLabel, normalGamesPlayedLabel, hardGamesPlayedLabel;
    private JLabel easyWinsLabel, normalWinsLabel, hardWinsLabel;
    private JLabel easyFastestTimeLabel, normalFastestTimeLabel, hardFastestTimeLabel;

    private MainMenuButton back;
    public StatsPanel(MainFrame mFrame, Sound sound){
        back = new MainMenuButton(mFrame, sound);
        statsFile = new File(STATS_FILE_PATH);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(statsFile));
            easyGamesPlayed = Integer.parseInt(reader.readLine());
            easyWins = Integer.parseInt(reader.readLine());
            easyFastestTime = Integer.parseInt(reader.readLine());
            normalGamesPlayed = Integer.parseInt(reader.readLine());
            normalWins = Integer.parseInt(reader.readLine());
            normalFastestTime = Integer.parseInt(reader.readLine());
            hardGamesPlayed = Integer.parseInt(reader.readLine());
            hardWins = Integer.parseInt(reader.readLine());
            hardFastestTime = Integer.parseInt(reader.readLine());
            reader.close();
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        easyGamesPlayedLabel = new JLabel("Easy Games Played: " + easyGamesPlayed);
        easyWinsLabel = new JLabel("Easy Games Won: " + easyWins);
        easyFastestTimeLabel = new JLabel("Easy Fastest Time: " + 
        easyFastestTime/60 + ":" + String.format("%02d",easyFastestTime%60));

        normalGamesPlayedLabel = new JLabel("Normal Games Played: " + normalGamesPlayed);
        normalWinsLabel = new JLabel("Normal Games Won: " + normalWins);
        normalFastestTimeLabel = new JLabel("Normal Fastest Time: " +
        normalFastestTime/60 + ":" + String.format("%02d",normalFastestTime%60));

        hardGamesPlayedLabel = new JLabel("Hard Games Played: " + hardGamesPlayed);
        hardWinsLabel = new JLabel("Hard Games Won: " + hardWins);
        hardFastestTimeLabel = new JLabel("Hard Fastest Time: " +
        hardFastestTime/60 + ":" + String.format("%02d",hardFastestTime%60));
    
        this.addComponent(easyGamesPlayedLabel);
        this.addComponent(easyWinsLabel);
        this.addComponent(easyFastestTimeLabel);

        this.addComponent(normalGamesPlayedLabel);
        this.addComponent(normalWinsLabel);
        this.addComponent(normalFastestTimeLabel);

        this.addComponent(hardGamesPlayedLabel);
        this.addComponent(hardWinsLabel);
        this.addComponent(hardFastestTimeLabel);

        this.addComponent(back);
        this.setUpFont(this);
    }

    public void statsUpdated(){updatedStats = true;}

    public void incrementGamesPlayed(byte difficulty){
        switch(difficulty){
            case GamePanel.EASY:
                easyGamesPlayedLabel.setText("Easy Games Played: " + ++easyGamesPlayed);
                break;
            case GamePanel.NORMAL:
                normalGamesPlayedLabel.setText("Normal Games Played: " + ++normalGamesPlayed);
                break;
            case GamePanel.HARD:
                hardGamesPlayedLabel.setText("Hard Games Played: " + ++hardGamesPlayed);
                break;
        }
        
    }

    public void incrementWins(byte difficulty){
        switch(difficulty){
            case GamePanel.EASY:
                easyWinsLabel.setText("Easy Games Won: " + ++easyWins);
                break;
            case GamePanel.NORMAL:
                normalWinsLabel.setText("Normal Games Won: " + ++normalWins);
                break;
            case GamePanel.HARD:
                hardWinsLabel.setText("Hard Games Won: " + ++hardWins);
                break;
        }
    }

    public void setFastestTime(int time, byte difficulty){
        if(difficulty == GamePanel.EASY && (easyWins== 1 || time < easyFastestTime)){
            easyFastestTime = time;
            easyFastestTimeLabel.setText("Easy Fastest Time: " + 
            easyFastestTime/60 + ":" + String.format("%02d",easyFastestTime%60));
        } else if(difficulty == GamePanel.NORMAL && (normalWins == 1 || time < normalFastestTime)){
            normalFastestTime = time;
            normalFastestTimeLabel.setText("Normal Fastest Time: " + 
            normalFastestTime/60 + ":" + String.format("%02d",normalFastestTime%60));
        } else if(difficulty == GamePanel.HARD && (hardWins == 1 || time < hardFastestTime)){
            hardFastestTime = time;
            hardFastestTimeLabel.setText("Hard Fastest Time: " + 
            hardFastestTime/60 + ":" + String.format("%02d",hardFastestTime%60));
        }
    }

    public void saveStats(){
        if(updatedStats){
            try {
                statsFile.delete();
                statsFile.createNewFile();
                FileWriter writer = new FileWriter(statsFile);
                writer.write(easyGamesPlayed + "\n" + easyWins + "\n" + easyFastestTime + "\n" +
                normalGamesPlayed + "\n" + normalWins + "\n" + normalFastestTime + "\n" +
                hardGamesPlayed + "\n" + hardWins + "\n" + hardFastestTime);
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
